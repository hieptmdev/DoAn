import {Component, HostListener, Input, OnInit} from '@angular/core';
import {ThemeOptions} from '../../../../theme-options';
import {ActivatedRoute} from '@angular/router';
import {CategoryService} from '../../../../services/category.service';
import {User} from '../../../../model/user';
import {UserService} from '../../../../services/user.service';
import {StorageService} from '../../../../services/storage.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  currentUser: User = new User();
  newInnerWidth: number;
  innerWidth: number;
  activeId = 'dashboardsMenu';
  categoriesParent: any;
  categoriesChild: any;

  constructor(public globals: ThemeOptions,
              private activatedRoute: ActivatedRoute,
              private categoryService: CategoryService,
              private userService: UserService,
              private storageService: StorageService) { }

  ngOnInit(): void {
    setTimeout(() => {
      this.innerWidth = window.innerWidth;
      if (this.innerWidth < 1200) {
        this.globals.toggleSidebar = true;
      }
    });

    this.getCurrentUser();
  }

  getParentCategory(): void{
    this.categoryService.getParentCategory(this.currentUser.roleId)
      .subscribe(data => {
        this.categoriesParent = data.body;
      }, error => console.log(error));
  }

  getChildCategory(parentCategoryId): void{
    this.categoryService.getChildCategory(this.currentUser.roleId, parentCategoryId)
      .subscribe(data => {
        this.categoriesChild = data.body;
      }, error => console.log(error));
  }

  getCurrentUser(): void {
    this.userService.getUserByUsername(this.storageService.getUsername())
      .subscribe(data => {
        this.currentUser = data.body;
        this.getParentCategory();
      }, error => console.log(error));
  }

  toggleSidebar(): void {
    this.globals.toggleSidebar = !this.globals.toggleSidebar;
  }

  sidebarHover(): void {
    this.globals.sidebarHover = !this.globals.sidebarHover;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event): void {
    this.newInnerWidth = event.target.innerWidth;

    if (this.newInnerWidth < 1200) {
      this.globals.toggleSidebar = true;
    } else {
      this.globals.toggleSidebar = false;
    }
  }
}
