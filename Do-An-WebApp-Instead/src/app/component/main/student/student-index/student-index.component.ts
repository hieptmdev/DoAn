import {Component, OnInit, TemplateRef} from '@angular/core';
import {User} from '../../../../model/user';
import {StudentService} from '../../../../service/student.service';
import {Student} from '../../../../model/student';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {AppUtil} from '../../../../config/app-util';

@Component({
  selector: 'app-student-index',
  templateUrl: './student-index.component.html',
  styleUrls: ['./student-index.component.css']
})
export class StudentIndexComponent implements OnInit {
  currentUser: User;

  maxSize = 5;
  collectionSize: any;
  page = 1;
  pageSize = 10;

  students: Student[];
  dataSearch: any;
  deleteData: Student;

  constructor(private studentService: StudentService,
              private modalService: NgbModal,
              private router: Router,
              private route: ActivatedRoute,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.search(this.dataSearch);
  }

  search($event: any): void {
    this.dataSearch = $event;
    this.studentService.search(this.dataSearch, this.page - 1, this.pageSize)
      .subscribe(data => {
        this.students = data.body.content;
        this.collectionSize = data.body.totalElements;
      }, error => {
        this.errorHandle(error);
      });
  }

  deleteById(): void{
    this.studentService.deleteById(this.deleteData.id)
      .subscribe(data => {
        if (data.body.code === 400) {
          this.toastr.error('Có lỗi xảy ra! Xóa thất bạ!', 'Notification', {timeOut: 3000});
        }
        if (data.body.code === 200) {
          this.toastr.success('Thực hiện xóa thành công', 'Notification', {timeOut: 3000});
          this.search(this.dataSearch);
        }
        this.deleteData = null;
        this.modalService.dismissAll();
      }, error => {
        this.errorHandle(error);
        this.deleteData = null;
        this.modalService.dismissAll();
      });
  }

  studentInfo(student: Student): void{
    this.router.navigate([`detail/${student.code}`], {relativeTo: this.route}).then(null);
  }

  openModalDelete(modal: TemplateRef<any>, student: Student): void {
    this.modalService.open(modal, {
      centered: true,
      backdrop: 'static'
    });
    this.deleteData = student;
  }

  score(student: Student): void {
    this.router.navigate([`detail/${student.code}/score`], {relativeTo: this.route}).then(null);
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
