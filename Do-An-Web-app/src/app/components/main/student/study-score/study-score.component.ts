import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from 'src/app/model/student';
import { StudyScore } from 'src/app/model/study-score';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-study-score',
  templateUrl: './study-score.component.html',
  styleUrls: ['./study-score.component.css']
})
export class StudyScoreComponent implements OnInit {
  semester: [];
  selectedSemester: any;
  student: Student = new Student();
  studyScores: StudyScore[];

  constructor(private studentService: StudentService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.loadData(params.get('code'));
    });
  }

  loadData(code){
    this.studentService.findByCode(code).subscribe(
      data => {
        this.student = data.body;
        this.studentService.findAllScoreByStudentCode(code).subscribe(
          data => {
            this.studyScores = data.body;
          }, error => console.log(error));
      }, error => console.log(error));
  }

  back() {
    this.router.navigate(['home/students']).then(null);
  }
}
