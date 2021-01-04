import { Component, OnInit } from '@angular/core';
import {User} from '../../model/user';
import {UserService} from '../../service/user.service';
import {StorageService} from '../../service/storage.service';
import {ToastrService} from 'ngx-toastr';
import {AppUtil} from '../../config/app-util';
import {Router} from '@angular/router';
import {JwtHelperService} from '@auth0/angular-jwt';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  currentUser: User;

  constructor(private userService: UserService,
              private storageService: StorageService,
              private toastr: ToastrService,
              private router: Router,
              private jwtHelperService: JwtHelperService) {
    this.getCurrentUser();
  }

  ngOnInit(): void {
  }

  public getCurrentUser(): void{
    this.userService.getUserByUsername(this.jwtHelperService.decodeToken(this.storageService.getAccessToken()).user_name)
      .subscribe(
      data => {
        this.currentUser = data.body;
      }, error => {
        this.errorHandle(error);
      });
  }

  public onActivate($event: any): void{
    this.userService.getUserByUsername(this.storageService.getLoginInfo().username).subscribe(
      data => {
        $event.currentUser = data.body;
      }, error => {
        this.errorHandle(error);
      });
  }

  public errorHandle(error): void{
    if (error.status === 401){
      this.router.navigate(['login']).then(null);
    }else if (error.status === 500){
      this.router.navigate(['error/500']).then(null);
    } else {
      this.toastr.error('Có lỗi xảy ra!', 'Notification', {timeOut: 3000});
    }
  }
}
