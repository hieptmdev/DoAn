import { Component, OnInit } from '@angular/core';
import {ThemeOptions} from '../../theme-options';
import {User} from '../../model/user';
import {UserService} from '../../services/user.service';
import {StorageService} from '../../services/storage.service';
import { StudentComponent } from './student/student.component';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  currentUser: User = new User();

  constructor(public globals: ThemeOptions,
              private userService: UserService,
              private storageService: StorageService) {
    // this.storageService.setInfoLogin('sysadmin');
  }

  ngOnInit(): void {
    // this.storageService.setInfoLogin('sysadmin');
  }

  public onActivate(cpn): void {
    this.userService.getUserByUsername(this.storageService.getUsername())
      .subscribe(data => {
        cpn.currentUser = data.body;
        this.storageService.setUnitAndRole(data.body.unitId, data.body.roleId);
      }, error => console.log(error));
  }

  toggleSidebarMobile(): void {
    this.globals.toggleSidebarMobile = !this.globals.toggleSidebarMobile;
  }
}
