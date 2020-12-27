import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRoutingModule } from './student-routing.module';
import { StudentSearchComponent } from './student-search/student-search.component';
import { StudentIndexComponent } from './student-index/student-index.component';
import { StudentFormComponent } from './student-form/student-form.component';


@NgModule({
  declarations: [
    StudentSearchComponent,
    StudentIndexComponent,
    StudentFormComponent
  ],
  imports: [
    CommonModule,
    StudentRoutingModule
  ]
})
export class StudentModule { }
