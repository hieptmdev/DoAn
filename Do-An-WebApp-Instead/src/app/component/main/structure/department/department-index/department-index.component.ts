import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-department-index',
  templateUrl: './department-index.component.html',
  styleUrls: ['./department-index.component.css']
})
export class DepartmentIndexComponent implements OnInit {
  dataSearch: any;
  actionData: any;
  pageSize = 10;
  maxSize = 5;
  page = 1;
  collectionSize: any;
  departments: any;

  constructor() { }

  ngOnInit(): void {
    this.search(null);
  }

  search($event: any): void{
    this.dataSearch = $event;
  }

  deleteById(): void {

  }

  pageChange(): void {
    this.search(this.dataSearch);
  }
}
