import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-unit-index',
  templateUrl: './unit-index.component.html',
  styleUrls: ['./unit-index.component.css']
})
export class UnitIndexComponent implements OnInit {
  dataSearch: any;
  actionData: any;
  collectionSize: any;
  page = 1;
  maxSize = 5;
  pageSize = 10;
  units: any;

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
