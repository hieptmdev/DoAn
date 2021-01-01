import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {User} from '../../../../model/user';
import {StorageService} from '../../../../service/storage.service';
import {UserService} from '../../../../service/user.service';
import {HttpLoader} from '../../../../transloco.loader';
import {TranslocoService} from '@ngneat/transloco';
import {Router} from '@angular/router';

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
  @Input() currentUser: User = new User();

  constructor(private storageService: StorageService,
              private userService: UserService,
              private httpLoader: HttpLoader,
              private translocoService: TranslocoService,
              private router: Router) { }

  ngOnInit(): void {
  }

  changeLanguage(code: string): void {
    if (code === 'vi'){
      this.language.label = 'Việt Nam';
      this.language.flag = 'flag-icon-vn';
    }else {
      this.language.label = 'English';
      this.language.flag = 'flag-icon-us';
    }
    this.translocoService.setActiveLang(code);
  }

  logout(): void{
    this.storageService.clearStorage();
    this.router.navigate(['login']).then(null);
  }

  goToManageUser(): void {
    this.router.navigate(['home/users']).then(null);
  }
}
