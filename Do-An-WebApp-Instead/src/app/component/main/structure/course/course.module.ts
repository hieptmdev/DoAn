import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CourseRoutingModule } from './course-routing.module';
import { CourseIndexComponent } from './course-index/course-index.component';
import { CourseFormComponent } from './course-form/course-form.component';
import { CourseSearchComponent } from './course-search/course-search.component';
import {TranslocoModule} from '@ngneat/transloco';
import {FormsModule} from '@angular/forms';
import {NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [CourseIndexComponent, CourseFormComponent, CourseSearchComponent],
  imports: [
    CommonModule,
    CourseRoutingModule,
    TranslocoModule,
    FormsModule,
    NgbPaginationModule
  ]
})
export class CourseModule { }
