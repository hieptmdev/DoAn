import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgForm} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CourseService} from '../../../../service/course.service';
import {UnitService} from '../../../../service/unit.service';
import {Course} from '../../../../model/course';
import {Unit} from '../../../../model/unit';
import {AppUtil} from '../../../../config/app-util';

@Component({
  selector: 'app-student-search',
  templateUrl: './student-search.component.html',
  styleUrls: ['./student-search.component.css']
})
export class StudentSearchComponent implements OnInit {
  @Output() eventSearch: EventEmitter<any> = new EventEmitter<any>();

  courses: Course[];
  units: Unit[];

  selectedUnit: Unit;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private courseService: CourseService,
              private unitService: UnitService) { }

  ngOnInit(): void {
    this.importUnit();
    this.importCourse();
  }

  search(formSearchSt: NgForm): void {
    this.eventSearch.emit(formSearchSt.value);
  }

  addStudent(): void {
    this.router.navigate(['add'], {relativeTo: this.route}).then(null);
  }

  importCourse(): void{
    this.courseService.findAll()
      .subscribe(data => {
        this.courses = data.body;
      }, error => {
        AppUtil.errorHandle(error);
      });
  }

  importUnit(): void{
    this.unitService.findAllUnit()
      .subscribe(data => {
        this.units = data.body;
      }, error => {
        AppUtil.errorHandle(error);
      });
  }
}
