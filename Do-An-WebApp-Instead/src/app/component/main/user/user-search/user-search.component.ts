import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UserService} from '../../../../service/user.service';
import {UnitService} from '../../../../service/unit.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {AppUtil} from '../../../../config/app-util';

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
              private route: ActivatedRoute) { }

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
    this.untService.findAllUnit()
      .subscribe(data => {
        this.units = data.body;
      }, error => AppUtil.errorHandle(error));
  }
}
