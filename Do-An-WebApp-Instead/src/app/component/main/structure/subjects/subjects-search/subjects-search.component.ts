import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-subjects-search',
  templateUrl: './subjects-search.component.html',
  styleUrls: ['./subjects-search.component.css']
})
export class SubjectsSearchComponent implements OnInit {
  @Output() eventSearch: EventEmitter<any> = new EventEmitter<any>();
  units: any;
  departments: any;

  constructor() { }

  ngOnInit(): void {
    this.importUnit();
    this.importDepartment();
  }

  search(data: any): void {
    this.eventSearch.emit(data.value);
  }

  importUnit(): void{

  }

  importDepartment(): void {

  }

  unitChange($event): void {

  }
}
