import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-subjects-index',
  templateUrl: './subjects-index.component.html',
  styleUrls: ['./subjects-index.component.css']
})
export class SubjectsIndexComponent implements OnInit {
  subjects: any;
  dataSearch: any;
  actionData: any;
  collectionSize: any;
  page: any;
  maxSize: any;
  pageSize: any;

  constructor() { }

  ngOnInit(): void {
    this.search(null);
  }

  pageChange(): void {
    this.search(this.dataSearch);
  }

  deleteById(): void {

  }

  search($event: any): void {
    this.dataSearch = $event;
  }
}
