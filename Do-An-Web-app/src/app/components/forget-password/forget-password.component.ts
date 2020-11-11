import { Component, OnInit } from '@angular/core';
import {environment} from '../../../environments/environment';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
  label = environment.label;
  sent: boolean;

  constructor() { }

  ngOnInit(): void {
    this.sent = false;
  }

  sendCode(): void {
    this.sent = !this.sent;
  }

  back(): void {
    this.sent = !this.sent;
  }
}
