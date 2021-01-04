import { Component, OnInit } from '@angular/core';
import {Student} from '../../../../model/student';
import {StudentService} from '../../../../service/student.service';
import {ToastrService} from 'ngx-toastr';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-student-score',
  templateUrl: './student-score.component.html',
  styleUrls: ['./student-score.component.css']
})
export class StudentScoreComponent implements OnInit {
  student: Student = new Student();
  studentScore: any;

  studentCode: any;

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
        this.errorHandle(error);
      });
  }

  loadScoreData(code): void{
    this.studentService.findAllScoreByStudentCode(code)
      .subscribe(data => {
        this.studentScore = data.body;
        this.collectionSize = this.studentScore.length;
      }, error => {
        this.errorHandle(error);
      });
  }

  back(): void {
    this.router.navigate(['home/students']).then(null);
  }

  studentInfo(): void {
    this.router.navigate([`home/students/detail/${this.studentCode}`]).then(null);
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
