import { Component, OnInit } from '@angular/core';
import {User} from '../../model/user';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  currentUser: User;

  constructor() { }

  ngOnInit(): void {
  }

  public receiveCurrentUser($event): void {
    this.currentUser = $event;
  }
}
