import {Component, Input, OnInit} from '@angular/core';
import {ThemeOptions} from '../../../../theme-options';
import {User} from '../../../../model/user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input() currentUser: User;
  isActive: any;

  constructor(public globals: ThemeOptions) { }

  ngOnInit(): void {
  }

  toggleSidebarMobile(): void {
    this.globals.toggleSidebarMobile = !this.globals.toggleSidebarMobile;
  }

  toggleHeaderMobile(): void {
    this.globals.toggleHeaderMobile = !this.globals.toggleHeaderMobile;
  }
}
