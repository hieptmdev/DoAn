import { Component, OnInit } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {ClassSubjectService} from '../../../../service/class-subject.service';

@Component({
  selector: 'app-class-subject-index',
  templateUrl: './class-subject-index.component.html',
  styleUrls: ['./class-subject-index.component.css']
})
export class ClassSubjectIndexComponent implements OnInit {
  actionData: any;
  dataSearch: any;
  classSubjects: any;
  collectionSize: any;
  page = 1;
  maxSize = 5;
  pageSize = 10;

  constructor(private modalService: NgbModal,
              private router: Router,
              private toastr: ToastrService,
              private classSubjectService: ClassSubjectService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.search(null);
  }

  search($event: any): void {
    this.dataSearch = $event;
    this.classSubjectService.search(this.dataSearch, this.page - 1, this.pageSize)
      .subscribe(data => {
        this.classSubjects = data.body.content;
        this.collectionSize = data.body.totalElements;
      }, error => this.errorHandle(error));
  }

  openModal(modal: any, cs: any): void {
    this.modalService.open(modal, {
      centered: true,
      backdrop: 'static'
    });
    this.actionData = cs;
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

  deleteById(): void {
  }

  detail(id): void {
    this.router.navigate(['detail', id], {relativeTo: this.route}).then(null);
  }
}
