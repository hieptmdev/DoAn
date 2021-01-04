import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UnitService} from '../../../../service/unit.service';
import {AppUtil} from '../../../../config/app-util';
import {DepartmentService} from '../../../../service/department.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {SubjectService} from '../../../../service/subject.service';
import {CourseService} from '../../../../service/course.service';

@Component({
  selector: 'app-class-subject-search',
  templateUrl: './class-subject-search.component.html',
  styleUrls: ['./class-subject-search.component.css']
})
export class ClassSubjectSearchComponent implements OnInit {
  @Output() eventSearch: EventEmitter<any> = new EventEmitter<any>();

  units: any;
  departments: any;
  subjects: any;
  courses: any;

  constructor(private unitService: UnitService,
              private departmentService: DepartmentService,
              private router: Router,
              private route: ActivatedRoute,
              private toastr: ToastrService,
              private subjectService: SubjectService,
              private courseService: CourseService) { }

  ngOnInit(): void {
    this.importUnit();
    this.importDepartment();
    this.importSubject();
    this.importCourse();
  }

  search(formSearchUser: any): void {
    this.eventSearch.emit(formSearchUser.value);
  }

  addCS(): void {
    this.router.navigate(['add'], {relativeTo: this.route}).then(null);
  }

  importUnit(): void{
    this.unitService.findAllUnit()
      .subscribe(data => {
        this.units = data.body;
      }, error => this.errorHandle(error));
  }

  importDepartment(): void{
    this.departmentService.findAll()
      .subscribe(data => {
        this.departments = data.body;
      }, error => {
        this.errorHandle(error);
      });
  }

  importSubject(): void{
    this.subjectService.findAll()
      .subscribe(data => {
        this.subjects = data.body;
      }, error => {
        this.errorHandle(error);
      });
  }

  importCourse(): void{
    this.courseService.findAll()
      .subscribe(data => {
        this.courses = data.body;
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
}
