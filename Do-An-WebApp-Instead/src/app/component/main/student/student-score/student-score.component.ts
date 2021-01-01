import { Component, OnInit } from '@angular/core';
import {Student} from '../../../../model/student';
import {StudentService} from '../../../../service/student.service';
import {ToastrService} from 'ngx-toastr';
import {ActivatedRoute, Router} from '@angular/router';
import {AppUtil} from '../../../../config/app-util';

@Component({
  selector: 'app-student-score',
  templateUrl: './student-score.component.html',
  styleUrls: ['./student-score.component.css']
})
export class StudentScoreComponent implements OnInit {
  student: Student = new Student();
  studentScore: any;

  studentCode: any;
  urlBack: any;

  collectionSize: any;
  page = 1;
  maxSize = 5;
  pageSize = 10;

  constructor(private studentService: StudentService,
              private toastr: ToastrService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    console.log(this.route);
    this.route.paramMap.subscribe(param => {
      if (param.get('code')){
        this.studentCode = param.get('code');
        this.getStudentByCode(this.studentCode);
        this.loadScoreData(this.studentCode);
      }
    });
  }

  getStudentByCode(code): void{
    this.studentService.findStudentByCode(code)
      .subscribe(data => {
        this.student = data.body;
      }, error => {
        AppUtil.errorHandle(error);
      });
  }

  loadScoreData(code): void{
    this.studentService.findAllScoreByStudentCode(code)
      .subscribe(data => {
        this.studentScore = data.body;
        this.collectionSize = this.studentScore.length;
      }, error => {
        AppUtil.errorHandle(error);
      });
  }

  back(): void {
    this.router.navigate(['home/students']).then(null);
  }

  studentInfo(): void {
    this.router.navigate([`home/students/detail/${this.studentCode}`]).then(null);
  }
}
