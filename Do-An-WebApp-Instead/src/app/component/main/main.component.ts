import { Component, OnInit } from '@angular/core';
import {User} from '../../model/user';
import {UserService} from '../../service/user.service';
import {StorageService} from '../../service/storage.service';
import {ToastrService} from 'ngx-toastr';
import {AppUtil} from '../../config/app-util';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  currentUser: User;

  constructor(private userService: UserService,
              private storageService: StorageService,
              private toastr: ToastrService) {
    this.getCurrentUser();
  }

  ngOnInit(): void {
  }

  public getCurrentUser(): void{
    this.userService.getUserByUsername(this.storageService.getLoginInfo().username).subscribe(
      data => {
        this.currentUser = data.body;
      }, error => {
        AppUtil.errorHandle(error);
      });
  }

  public onActivate($event: any): void{
    this.userService.getUserByUsername(this.storageService.getLoginInfo().username).subscribe(
      data => {
        $event.currentUser = data.body;
      }, error => {
        AppUtil.errorHandle(error);
      });
  }
}
