import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {User} from '../../../../model/user';
import {StorageService} from '../../../../service/storage.service';
import {UserService} from '../../../../service/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  language: any = {
    label: 'Việt Nam',
    flag: 'flag-icon-vn'
  };
  @Output() eventEmitter = new EventEmitter<any>();
  currentUser: User;

  constructor(private storageService: StorageService,
              private userService: UserService) { }

  ngOnInit(): void {
    this.getCurrentUser();
    this.eventEmitter.emit(this.currentUser);
  }

  public getCurrentUser(): void{
    this.userService.getUserByUsername(this.storageService.getLoginInfo().username).subscribe(
      data => {
        this.currentUser = data.body;
      }, error => console.log(error)
    );
  }

  changeLanguage(code: string): void {
    if (code === 'VN'){
      this.language.label = 'Việt Nam';
      this.language.flag = 'flag-icon-vn';
    }else {
      this.language.label = 'English';
      this.language.flag = 'flag-icon-us';
    }
  }
}
