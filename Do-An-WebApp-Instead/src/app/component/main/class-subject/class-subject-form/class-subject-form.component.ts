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
  classSubjectCode: any;
  classDetails: any;
  isSaveOrUpdate = false;
  subjects: any;
  courses: any;
  teachers: any;
  selectedDepartment: any;
  departments: any;
  selectedUnit: any;
  units: any;

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
        this.classSubjectCode = null;
      }else {
        this.importSubject();
        this.importTeacher();
        this.importDepartment();
        this.classSubjectCode = param.get('id');
        this.getClassSubjectByCode(this.classSubjectCode);
      }
    });
  }

  saveOrUpdate(): void {

  }

  getClassSubjectByCode(id): void{
    this.classSubjectService.findById(id)
      .subscribe(data => {
        this.classSubject = data.body;
        this.classDetails = data.body.classDetails;
        this.classSubject.startDate = formatDate(this.classSubject.startDate, 'yyyy-MM-dd', 'vi');
        this.classSubject.endDate = formatDate(this.classSubject.endDate, 'yyyy-MM-dd', 'vi');
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

  openModalSave(modal: TemplateRef<any>): void {
    this.modalService.open(modal, {
      centered: true,
      backdrop: 'static'
    });
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

  }
}
