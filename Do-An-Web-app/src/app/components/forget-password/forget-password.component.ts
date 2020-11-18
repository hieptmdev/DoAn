import { Component, OnInit } from '@angular/core';
import {environment} from '../../../environments/environment';
import {UserService} from '../../services/user.service';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
  label = environment.label;
  sent: boolean;
  isError: boolean;
  message: string;

  constructor(private userService: UserService,
              private router: Router) { }

  ngOnInit(): void {
    this.sent = false;
    this.isError = false;
  }

  sendCode(form: NgForm): void {
    if (form.valid) {
      this.userService.sendCode(form.value)
        .subscribe(data => {
            console.log(data);
            if (data.body.code === 200) {
              this.sent = !this.sent;
              this.isError = false;
              this.message = null;
            } else {
              this.isError = !this.isError;
            }
          },
          error => {
            console.log(error);
            this.isError = !this.isError;
          });
    }else {
      this.message = this.label.ERR_REQUIREDS;
    }
  }

  changePassword(form: NgForm): void{
    if (form.valid) {
      this.userService.changePassword(form.value)
        .subscribe(data => {
            console.log(data);
            if (data.body.code === 200) {
              this.sent = !this.sent;
              this.isError = false;
              this.message = null;
              this.router.navigate(['login']).then(null);
            } else if (data.body.code === 400){
              this.message = this.label.ERR_CONFIRM_PASS;
            } else {
              this.isError = !this.isError;
            }
          },
          error => {
            console.log(error);
            this.isError = !this.isError;
          });
    }else {
      this.message = this.label.ERR_REQUIREDS;
    }
  }

  back(): void {
    this.sent = !this.sent;
  }
}
