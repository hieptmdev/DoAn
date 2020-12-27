import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SubjectRoutingModule } from './subject-routing.module';
import { SubjectIndexComponent } from './subject-index/subject-index.component';
import { SubjectFormComponent } from './subject-form/subject-form.component';
import { SubjectSearchComponent } from './subject-search/subject-search.component';


@NgModule({
  declarations: [SubjectIndexComponent, SubjectFormComponent, SubjectSearchComponent],
  imports: [
    CommonModule,
    SubjectRoutingModule
  ]
})
export class SubjectModule { }
