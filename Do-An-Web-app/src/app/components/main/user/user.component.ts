import { Component, OnInit } from '@angular/core';
import {environment} from '../../../../environments/environment';
import {User} from '../../../model/user';
import {UserService} from '../../../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  label = environment.label;
  pageOption = environment.page_select_option;
  collectionSize: number;
  page = 0;
  pageSize = this.pageOption[1];
  users: User[];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.search();
  }

  search(): void {
    this.userService.search(this.page, this.pageSize)
      .subscribe(data => {
        this.users = data.body.content;
        this.collectionSize = data.body.totalElements;
      }, error => console.log(error));
  }

  lock(id: number): void {
    this.userService.lock(id)
      .subscribe(data => {
        if (data.body.code === 200){
          this.search();
        }else {

        }
      }, error => console.log(error));
  }

  open(id: number): void {
    this.userService.openLock(id)
      .subscribe(data => {
        if (data.body.code === 200){
          this.search();
        }else {

        }
      }, error => console.log(error));
  }
}
