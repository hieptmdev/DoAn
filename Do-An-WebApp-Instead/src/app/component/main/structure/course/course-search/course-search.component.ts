import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-course-search',
  templateUrl: './course-search.component.html',
  styleUrls: ['./course-search.component.css']
})
export class CourseSearchComponent implements OnInit {
  @Output() eventSearch: EventEmitter<any> = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  search(data: any): void {
    this.eventSearch.emit(data.value);
  }
}
