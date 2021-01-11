import {Component, OnInit, TemplateRef} from '@angular/core';
import {User} from '../../../../model/user';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {UserService} from '../../../../service/user.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {UnitService} from '../../../../service/unit.service';
import {RoleService} from '../../../../service/role.service';
import {DepartmentService} from '../../../../service/department.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  user: User = new User();
  units: any;
  roles: any;
  departments: any;
  isSaveOrUpdate = true;

  constructor(private modalService: NgbModal,
              private userService: UserService,
              private router: Router,
              private toastr: ToastrService,
              private unitService: UnitService,
              private roleService: RoleService,
              private departmentService: DepartmentService) { }

  ngOnInit(): void {
    this.importRole();
    this.importUnit();
  }

  saveOrUpdate(): void {
    this.userService.saveOrUpdate(this.user)
      .subscribe(data => {
        this.modalService.dismissAll();
        if (data.body) {
          this.router.navigate(['home/students']).then(() => {
            this.toastr.success('Thực hiện thêm/sửa thành công!', 'Notification', {timeOut: 3000});
          });
        }else {
          this.toastr.error('Có lỗi xảy ra!', 'Notification', {timeOut: 3000});
        }
      }, error => this.errorHandle(error));
  }

  openModalSave(modal: TemplateRef<any>): void {
    this.modalService.open(modal, {
      centered: true,
      backdrop: 'static'
    });
  }

  back(): void {
    this.router.navigate(['home/users']).then(null);
  }

  importUnit(): void {
    this.unitService.findAllUnitForUser()
      .subscribe(data => {
        this.units = data.body;
      }, error => this.errorHandle(error));
  }

  importRole(): void {
    this.roleService.findAllRole()
      .subscribe(data => {
        this.roles = data.body;
      }, error => this.errorHandle(error));
  }

  importDepartment(unitId): void{
    this.departmentService.findAllByUnit(unitId)
      .subscribe(data => {
        this.departments = data.body;
      }, error => this.errorHandle(error));
  }

  unitChange(): void{
    this.importDepartment(this.user.unitId);
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

  cancel(): void {
    location.reload();
  }
}
