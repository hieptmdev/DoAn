import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-course-index',
  templateUrl: './course-index.component.html',
  styleUrls: ['./course-index.component.css']
})
export class CourseIndexComponent implements OnInit {
  dataSearch: any;
  actionData: any;
  courses: any;
  collectionSize: any;
  pageSize = 10;
  maxSize = 5;
  page = 1;

  constructor() { }

  ngOnInit(): void {
    this.search(null);
  }

  search($event: any): void {
    this.dataSearch = $event;
  }

  pageChange(): void {
    this.search(this.dataSearch);
  }

  deleteById(): void {

  }
}
