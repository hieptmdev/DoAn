import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {environment} from '../../../environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  label = environment.label;
  check: boolean;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.check = false;
  }

  login(): void {}

  remember(): void {
    this.check = !this.check;
  }
}
