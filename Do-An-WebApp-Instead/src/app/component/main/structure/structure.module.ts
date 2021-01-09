import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StructureRoutingModule } from './structure-routing.module';
import { UnitComponent } from './unit/unit.component';
import { CourseComponent } from './course/course.component';
import { DepartmentComponent } from './department/department.component';
import { SubjectsComponent } from './subjects/subjects.component';


@NgModule({
  declarations: [
    UnitComponent,
    CourseComponent,
    DepartmentComponent,
    SubjectsComponent],
  imports: [
    CommonModule,
    StructureRoutingModule
  ]
})
export class StructureModule { }
