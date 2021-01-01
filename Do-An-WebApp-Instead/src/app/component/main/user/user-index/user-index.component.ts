import {Component, OnInit, TemplateRef} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ToastrService} from 'ngx-toastr';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../../../service/user.service';
import {User} from '../../../../model/user';
import {AppUtil} from '../../../../config/app-util';

@Component({
  selector: 'app-user-index',
  templateUrl: './user-index.component.html',
  styleUrls: ['./user-index.component.css']
})
export class UserIndexComponent implements OnInit {
  users: User[];
  actionData: User;
  dataSearch: any;

  collectionSize: any;
  maxSize = 5;
  pageSize = 10;
  page = 1;

  constructor(private modalService: NgbModal,
              private toastr: ToastrService,
              private router: Router,
              private route: ActivatedRoute,
              private userService: UserService) { }

  ngOnInit(): void {
    this.search(this.dataSearch);
  }

  search($event: any): void {
    this.dataSearch = $event;
    this.userService.search(this.dataSearch, this.page, this.pageSize)
      .subscribe(data => {
        this.users = data.body.content;
        this.collectionSize = data.body.totalElements;
      }, error => AppUtil.errorHandle(error));
  }

  openModal(modal: TemplateRef<any>, user: User): void {
    this.modalService.open(modal, {
      centered: true,
      backdrop: 'static'
    });
    this.actionData = user;
  }

  deleteById(): void {}

  openLock(): void {
    this.userService.openLock(this.actionData.id)
      .subscribe(data => {
        if (data.body.code === 400) {
          this.toastr.error('Có lỗi xảy ra! Mở khóa thất bạ!', 'Notification', {timeOut: 3000});
        }
        if (data.body.code === 200) {
          this.toastr.success('Thực hiện mở khóa thành công', 'Notification', {timeOut: 3000});
          this.search(this.dataSearch);
        }
        this.actionData = null;
        this.modalService.dismissAll();
    }, error => AppUtil.errorHandle(error));
  }

  lock(): void{
    this.userService.lock(this.actionData.id)
      .subscribe(data => {
        if (data.body.code === 400) {
          this.toastr.error('Có lỗi xảy ra! Khóa thất bạ!', 'Notification', {timeOut: 3000});
        }
        if (data.body.code === 200) {
          this.toastr.success('Thực hiện khóa thành công', 'Notification', {timeOut: 3000});
          this.search(this.dataSearch);
        }
        this.actionData = null;
        this.modalService.dismissAll();
      }, error => AppUtil.errorHandle(error));
  }
}
