import { Component, OnInit } from '@angular/core';
import {CategoryService} from '../../../../service/category.service';
import {AppUtil} from '../../../../config/app-util';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  categoryParent: any;
  categoryChild: any;

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.getParentCategory();
  }

  getParentCategory(): void{
    this.categoryService.getParentCategory()
      .subscribe(data => {
        this.categoryParent = data.body;
      }, error => {
        AppUtil.errorHandle(error);
      });
  }

  getChildCategory(parentId): void {
    this.categoryService.getChildCategory(parentId)
      .subscribe(data => {
        this.categoryChild = data.body;
      }, error => {
        AppUtil.errorHandle(error);
      });
  }
}
