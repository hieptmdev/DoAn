import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UserService} from '../../../../service/user.service';
import {UnitService} from '../../../../service/unit.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {AppUtil} from '../../../../config/app-util';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-user-search',
  templateUrl: './user-search.component.html',
  styleUrls: ['./user-search.component.css']
})
export class UserSearchComponent implements OnInit {
  @Output() eventSearch: EventEmitter<any> = new EventEmitter<any>();
  units: any;


  constructor(private userService: UserService,
              private untService: UnitService,
              private router: Router,
              private route: ActivatedRoute,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.importUnit();
  }

  addUser(): void {
    this.router.navigate(['add'], {relativeTo: this.route}).then(null);
  }

  search(formSearchUser: NgForm): void {
    this.eventSearch.emit(formSearchUser.value);
  }

  importUnit(): void{
    this.untService.findAllUnitForUser()
      .subscribe(data => {
        this.units = data.body;
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
