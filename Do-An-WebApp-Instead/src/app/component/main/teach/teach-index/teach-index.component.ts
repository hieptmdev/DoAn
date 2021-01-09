import { Component, OnInit } from '@angular/core';
import {User} from '../../../../model/user';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {UserService} from '../../../../service/user.service';

@Component({
  selector: 'app-teach-index',
  templateUrl: './teach-index.component.html',
  styleUrls: ['./teach-index.component.css']
})
export class TeachIndexComponent implements OnInit {
  actionData: any;
  dataSearch: any;
  teachers: User[];
  collectionSize: any;
  page = 1;
  maxSize = 5;
  pageSize = 10;

  constructor(private router: Router,
              private toastr: ToastrService,
              private userService: UserService) { }

  ngOnInit(): void {
    this.search(null);
  }

  search($event?: any): void {
    this.dataSearch = $event;
  }

  pageChange(): void {
    this.search(this.dataSearch);
  }

  deleteById(): void {

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
