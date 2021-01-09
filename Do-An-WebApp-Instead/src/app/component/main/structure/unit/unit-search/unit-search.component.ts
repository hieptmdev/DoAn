import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-unit-search',
  templateUrl: './unit-search.component.html',
  styleUrls: ['./unit-search.component.css']
})
export class UnitSearchComponent implements OnInit {
  @Output() eventSearch: EventEmitter<any> = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  search(data: any): void {
    this.eventSearch.emit(data.value);
  }
}
