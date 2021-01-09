import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UnitService} from '../../../../service/unit.service';
import {DepartmentService} from '../../../../service/department.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-teach-search',
  templateUrl: './teach-search.component.html',
  styleUrls: ['./teach-search.component.css']
})
export class TeachSearchComponent implements OnInit {
  @Output() eventSearch: EventEmitter<any> = new EventEmitter<any>();
  units: any;
  departments: any;

  constructor(private unitService: UnitService,
              private departmentService: DepartmentService,
              private router: Router,
              private route: ActivatedRoute,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.importUnit();
    this.importDepartment();
  }

  search(data: any): void {
    this.eventSearch.emit(data.value);
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
      }, error => this.errorHandle(error));
  }

  unitChange($event): void{
    this.departmentService.findAllByUnit($event)
      .subscribe(data => {
        this.departments = data.body;
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
