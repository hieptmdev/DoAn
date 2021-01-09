import {Component, OnInit, TemplateRef} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ClassSubject} from '../../../../model/class-subject';
import {SubjectService} from '../../../../service/subject.service';
import {CourseService} from '../../../../service/course.service';
import {UserService} from '../../../../service/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {DepartmentService} from '../../../../service/department.service';
import {UnitService} from '../../../../service/unit.service';
import {ClassSubjectService} from '../../../../service/class-subject.service';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-class-subject-form',
  templateUrl: './class-subject-form.component.html',
  styleUrls: ['./class-subject-form.component.css']
})
export class ClassSubjectFormComponent implements OnInit {
  classSubject: ClassSubject = new ClassSubject();
  classSubjectId: any;
  isSaveOrUpdate = false;
  subjects: any;
  courses: any;
  teachers: any;
  selectedDepartment: any;
  departments: any;
  selectedUnit: any;
  units: any;
  page = 1;
  maxSize = 5;
  pageSize = 10;
  collectionSize: any;
  checkedAll = false;
  actionData: any;
  countChecked = 0;
  selectClassSubjectId: any;
  classSubjects: any;

  constructor(private modalService: NgbModal,
              private subjectService: SubjectService,
              private courseService: CourseService,
              private userService: UserService,
              private router: Router,
              private toastr: ToastrService,
              private departmentService: DepartmentService,
              private unitService: UnitService,
              private route: ActivatedRoute,
              private classSubjectService: ClassSubjectService) { }

  ngOnInit(): void {
    this.importCourse();
    this.importUnit();
    this.route.paramMap.subscribe(param => {
      if (param.get('id') == null){
        this.isSaveOrUpdate = true;
        this.classSubjectId = null;
      }else {
        this.importSubject();
        this.importTeacher();
        this.importDepartment();
        this.classSubjectId = param.get('id');
        this.getClassSubjectById(this.classSubjectId);
      }
    });
  }

  saveOrUpdate(): void {
    this.classSubjectService.saveOrUpdate(this.classSubject)
      .subscribe(data => {
        this.modalService.dismissAll();
        if (data.body) {
          this.router.navigate(['home/class-subject']).then(() => {
            this.toastr.success('Thực hiện thêm/sửa thành công!', 'Notification', {timeOut: 3000});
          });
        }else {
          this.toastr.error('Có lỗi xảy ra!', 'Notification', {timeOut: 3000});
        }
        this.modalService.dismissAll();
      }, error => {
        this.modalService.dismissAll();
        this.errorHandle(error);
      });
  }

  getClassSubjectById(id): void{
    this.classSubjectService.findById(id)
      .subscribe(data => {
        this.classSubject = data.body;
        this.classSubject.startDate = formatDate(this.classSubject.startDate, 'yyyy-MM-dd', 'vi');
        this.classSubject.endDate = formatDate(this.classSubject.endDate, 'yyyy-MM-dd', 'vi');
        this.collectionSize = this.classSubject.classDetails.length;
        this.importClassSubjects();
      }, error => this.errorHandle(error));
  }

  importUnit(): void{
    this.unitService.findAllUnit()
      .subscribe(data => {
        this.units = data.body;
      }, error => this.errorHandle(error));
  }

  importSubject(): void{
    this.subjectService.findAll()
      .subscribe(data => {
        this.subjects = data.body;
      }, error => this.errorHandle(error));
  }

  importCourse(): void{
    this.courseService.findAll()
      .subscribe(data => {
        this.courses = data.body;
      }, error => this.errorHandle(error));
  }

  importTeacher(): void{
    this.userService.findAllTeacher()
      .subscribe(data => {
        this.teachers = data.body;
      }, error => this.errorHandle(error));
  }

  importDepartment(): void{
    this.departmentService.findAll()
      .subscribe(data => {
        this.departments = data.body;
      }, error => this.errorHandle(error));
  }

  importClassSubjects(): void{
    this.classSubjectService.findAllClassSameSubject(this.classSubject.id, this.classSubject.subjectsId, this.classSubject.courseId)
      .subscribe(data => {
        this.classSubjects = data.body;
      }, error => this.errorHandle(error));
  }

  unitChange(): void{
    this.departmentService.findAllByUnit(this.selectedUnit)
      .subscribe(data => {
        this.departments = data.body;
      }, error => this.errorHandle(error));
  }

  departmentChange(): void{
    this.subjectService.findAllByDepartment(this.selectedDepartment)
      .subscribe(data => {
        this.subjects = data.body;
      }, error => this.errorHandle(error));

    this.userService.findAllTeacherByDepartment(this.selectedDepartment)
      .subscribe(data => {
        this.teachers = data.body;
      }, error => this.errorHandle(error));
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

  back(): void {
    this.router.navigate(['home/class-subject']).then(null);
  }

  cancel(): void {
    location.reload();
  }

  openModal(modal, cd?: any): void {
    this.modalService.open(modal, {
      centered: true,
      backdrop: 'static'
    });
    if (cd){
      this.actionData = cd;
    }
  }

  checkAll($event: Event): void {
    // @ts-ignore
    this.checkedAll = $event.currentTarget.checked;
    if (this.checkedAll){
      this.classSubject.classDetails.forEach(cd => cd.checked = true);
      this.countChecked = this.classSubject.classDetails.length;
    }else {
      this.classSubject.classDetails.forEach(cd => cd.checked = false);
      this.countChecked = 0;
    }
  }

  checkedOne($event: Event, classDetail: any): void {
    // @ts-ignore
    if ($event.currentTarget.checked){
      classDetail.checked = true;
      this.countChecked += 1;
      if (!this.checkedAll && this.countChecked === this.classSubject.classDetails.length){
        this.checkedAll = true;
      }
    }else {
      classDetail.checked = false;
      this.countChecked -= 1;
      if (this.checkedAll) {
        this.checkedAll = false;
      }
    }
  }

  delete(): void {
    if (this.actionData){
      this.classSubjectService.deleteClassDetailById(this.actionData.id)
        .subscribe(data => {
          if (data.status === 404) {
            this.toastr.warning('Dữ liệu không tồn tại', 'Notification', {timeOut: 3000});
          }
          if (data.status === 200) {
            this.toastr.success('Thực hiện xóa thành công', 'Notification', {timeOut: 3000});
            this.getClassSubjectById(this.classSubjectId);
          }
          this.countChecked = 0;
          this.actionData = null;
          this.modalService.dismissAll();
        }, error => {
          this.errorHandle(error);
          this.countChecked = 0;
          this.actionData = null;
          this.modalService.dismissAll();
        });
    }else {
      this.classSubjectService.deleteMultiClassDetail(this.classSubject)
        .subscribe(data => {
          if (data.status === 404) {
            this.toastr.warning('Dữ liệu không tồn tại', 'Notification', {timeOut: 3000});
          }
          if (data.status === 200) {
            this.toastr.success('Thực hiện xóa thành công', 'Notification', {timeOut: 3000});
            this.getClassSubjectById(this.classSubjectId);
          }
          this.countChecked = 0;
          this.modalService.dismissAll();
        }, error => {
          this.errorHandle(error);
          this.countChecked = 0;
          this.actionData = null;
          this.modalService.dismissAll();
        });
    }
  }

  transfer(): void{
    if (this.actionData){
      this.classSubjectService.transferById(this.actionData.id, this.selectClassSubjectId)
        .subscribe(data => {
          if (data.status === 404) {
            this.toastr.warning('Dữ liệu không tồn tại', 'Notification', {timeOut: 3000});
          }
          if (data.status === 200) {
            this.toastr.success('Thực hiện thao tác thành công', 'Notification', {timeOut: 3000});
            this.getClassSubjectById(this.classSubjectId);
          }
          this.countChecked = 0;
          this.actionData = null;
          this.modalService.dismissAll();
        }, error => {
          this.errorHandle(error);
          this.countChecked = 0;
          this.actionData = null;
          this.modalService.dismissAll();
        });
    }else {
      this.classSubjectService.transfer(this.classSubject, this.selectClassSubjectId)
        .subscribe(data => {
          if (data.status === 404) {
            this.toastr.warning('Dữ liệu không tồn tại', 'Notification', {timeOut: 3000});
          }
          if (data.status === 200) {
            this.toastr.success('Thực hiện thao tác thành công', 'Notification', {timeOut: 3000});
            this.getClassSubjectById(this.classSubjectId);
          }
          this.countChecked = 0;
          this.modalService.dismissAll();
        }, error => {
          this.countChecked = 0;
          this.errorHandle(error);
          this.actionData = null;
          this.modalService.dismissAll();
        });
    }
  }
}
