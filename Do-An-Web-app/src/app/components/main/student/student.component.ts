import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from 'src/app/model/course';
import { Student } from 'src/app/model/student';
import { Unit } from 'src/app/model/unit';
import { User } from 'src/app/model/user';
import { CourseService } from 'src/app/services/course.service';
import { StorageService } from 'src/app/services/storage.service';
import { StudentService } from 'src/app/services/student.service';
import { UnitService } from 'src/app/services/unit.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  currentUser: User;

  label = environment.label;
  pageOption = environment.page_select_option;
  collectionSize: number;
  page = 0;
  pageSize = this.pageOption[1];

  students: Student[];
  units: Unit[];
  selectedUnit: Unit;
  courses: Course[];
  selectedCourse: Course;
  code: string;
  name: string;
  className: string;
  course: string;
  unit: string;

  constructor(private studentService: StudentService,
              private courseService: CourseService,
              private unitService: UnitService,
              private storageService: StorageService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.importUnit();
    this.importCourse();
    this.search();
  }

  search() {
    if (this.selectedCourse){
      this.course = this.selectedCourse.id.toString();
    }
    if (this.selectedUnit){
      this.unit = this.selectedUnit.id.toString();
    }
    this.studentService.search(this.page, this.pageSize, this.code, this.name, this.course, this.unit)
      .subscribe(data => {
        this.students = data.body.content;
        this.collectionSize = data.body.totalElements;
      }, error => console.log(error));
  }

  importCourse() {
    this.courseService.getAll()
      .subscribe(data => {
        this.courses = data.body;
      }, error => console.log(error));
  }

  importUnit() {
    this.unitService.findAllForStudent(Number(this.storageService.getUnit()))
      .subscribe(data => {
        this.units = data.body;
        if (this.currentUser.unitId!=1&&this.currentUser.unitId!=2&&this.currentUser.unitId!=3&&this.currentUser.unitId!=8){
          this.selectedUnit = this.units[0];
        }
      }, error => console.log(error));
  }

  studyScore(stCode) {
    if(this.currentUser.unitId === 1 || this.currentUser.unitId === 8){    
      this.router.navigate([`score/${stCode}`], {relativeTo: this.route}).then(null);
    }else {
      alert("Tài khoản không có quyền truy cập mục này!")
    }
  }

  add() {
    this.router.navigate(['info'], {relativeTo: this.route}).then(null);
  }

  studentInfo(code){
    this.router.navigate(['info', code], {relativeTo: this.route}).then(null);
  } 
}
