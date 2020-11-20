import {Component, OnInit} from '@angular/core';
import {ThemeOptions} from '../../../../theme-options';
import {User} from '../../../../model/user';
import {environment} from '../../../../../environments/environment';
import {UserService} from '../../../../services/user.service';
import {StorageService} from '../../../../services/storage.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  currentUser: User = new User();
  isActive: any;
  label = environment.label;
  permission_sys = environment.permission_sys;

  constructor(public globals: ThemeOptions,
              private userService: UserService,
              private storageService: StorageService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getCurrentUser();
  }

  getCurrentUser(): void {
    this.userService.getUserByUsername(this.storageService.getUsername())
      .subscribe(data => {
        this.currentUser = data.body;
      }, error => console.log(error));
  }

  toggleSidebarMobile(): void {
    this.globals.toggleSidebarMobile = !this.globals.toggleSidebarMobile;
  }

  toggleHeaderMobile(): void {
    this.globals.toggleHeaderMobile = !this.globals.toggleHeaderMobile;
  }

  logout(): void {
    localStorage.clear();
    this.router.navigate(['login']).then(null);
  }

  profile(): void {
    this.router.navigate(['profile'], {relativeTo: this.route}).then(null);
  }

  manageUser(): void {
    this.router.navigate(['users'], {relativeTo: this.route}).then(null);
  }
}
