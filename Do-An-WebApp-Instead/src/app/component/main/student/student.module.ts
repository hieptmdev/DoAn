import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRoutingModule } from './student-routing.module';
import { StudentSearchComponent } from './student-search/student-search.component';
import { StudentIndexComponent } from './student-index/student-index.component';
import { StudentFormComponent } from './student-form/student-form.component';
import {NgbDropdownModule, NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';
import {TranslocoModule} from '@ngneat/transloco';
import {FormsModule} from '@angular/forms';
import {MainModule} from '../main.module';
import { StudentScoreComponent } from './student-score/student-score.component';

@NgModule({
  declarations: [
    StudentSearchComponent,
    StudentIndexComponent,
    StudentFormComponent,
    StudentScoreComponent
  ],
  imports: [
    CommonModule,
    StudentRoutingModule,
    NgbPaginationModule,
    TranslocoModule,
    NgbDropdownModule,
    FormsModule,
    MainModule,
  ]
})
export class StudentModule { }
