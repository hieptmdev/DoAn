import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-department-search',
  templateUrl: './department-search.component.html',
  styleUrls: ['./department-search.component.css']
})
export class DepartmentSearchComponent implements OnInit {
  @Output() eventSearch: EventEmitter<any> = new EventEmitter<any>();
  units: any;

  constructor() { }

  ngOnInit(): void {
  }

  search(data: any): void{
    this.eventSearch.emit(data.value);
  }

}
