import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { StorageService } from 'src/app/services/storage.service';
import {environment} from '../../../environments/environment';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  label = environment.label;
  check: boolean;
  username: string;
  password: string;

  constructor(private router: Router,
              private authService: AuthService,
              private storageService: StorageService) { }

  ngOnInit(): void {
    this.check = false;
  }

  login(): void {
    const info = {
      username: this.username,
      password: this.password,
      grant_type: 'password'
    };
    // this.authService.login(info)
    //   .subscribe(data => console.log(data),
    //     error => console.log(error));
    this.storageService.setInfoLogin(info);
    this.router.navigate(['home']).then(null);
  }

  remember(): void {
    this.check = !this.check;
  }
}
