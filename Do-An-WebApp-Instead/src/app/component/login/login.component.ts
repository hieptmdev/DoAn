import {Component, OnInit} from '@angular/core';
import {LoginForm} from '../../model/login-form';
import {AuthService} from '../../service/auth.service';
import {StorageService} from '../../service/storage.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: LoginForm;
  keepLogin: boolean;
  errMsg: any;

  constructor(private router: Router,
              private authService: AuthService,
              private storageService: StorageService) { }

  ngOnInit(): void {
    this.loginForm = this.storageService.getLoginInfo();
    if (this.loginForm != null && this.loginForm.username != null){
      this.keepLogin = true;
    }else {
      this.loginForm = new LoginForm();
      this.keepLogin = false;
    }
  }

  login(): void {
    this.authService.login(this.loginForm).subscribe(
      data => {
        this.errMsg = null;
        this.storageService.saveToken(data);
        if (this.keepLogin === true) {
          this.storageService.rememberLoginInfo(this.loginForm);
        }
        this.router.navigate(['home']).then(null);
      }, error => {
        if (error.status === 500){
          this.router.navigate(['error/500']).then(null);
        }
        this.errMsg = error.error.error_description;
      });
  }
}
