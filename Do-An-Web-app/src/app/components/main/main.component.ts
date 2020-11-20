import { Component, OnInit } from '@angular/core';
import {ThemeOptions} from '../../theme-options';
import {User} from '../../model/user';
import {UserService} from '../../services/user.service';
import {StorageService} from '../../services/storage.service';

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
    this.storageService.setInfoLogin('sysadmin');
  }

  ngOnInit(): void {
    // this.storageService.setInfoLogin('sysadmin');
    this.userService.getUserByUsername(this.storageService.getUsername())
      .subscribe(data => {
        this.currentUser = data.body;
      }, error => console.log(error));
  }

  public onActivate(cpn: any): void {
    cpn.currentUser = this.currentUser;
  }

  toggleSidebarMobile(): void {
    this.globals.toggleSidebarMobile = !this.globals.toggleSidebarMobile;
  }
}
