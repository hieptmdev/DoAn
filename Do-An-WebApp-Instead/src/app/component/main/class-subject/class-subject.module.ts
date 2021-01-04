import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClassSubjectRoutingModule } from './class-subject-routing.module';
import { ClassSubjectIndexComponent } from './class-subject-index/class-subject-index.component';
import { ClassSubjectFormComponent } from './class-subject-form/class-subject-form.component';
import { ClassSubjectSearchComponent } from './class-subject-search/class-subject-search.component';
import {TranslocoModule} from '@ngneat/transloco';
import {FormsModule} from '@angular/forms';
import {NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    ClassSubjectIndexComponent,
    ClassSubjectFormComponent,
    ClassSubjectSearchComponent
  ],
  imports: [
    CommonModule,
    ClassSubjectRoutingModule,
    TranslocoModule,
    FormsModule,
    NgbPaginationModule
  ]
})
export class ClassSubjectModule { }
