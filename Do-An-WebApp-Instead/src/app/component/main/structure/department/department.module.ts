import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DepartmentRoutingModule } from './department-routing.module';
import { DepartmentFormComponent } from './department-form/department-form.component';
import { DepartmentIndexComponent } from './department-index/department-index.component';
import { DepartmentSearchComponent } from './department-search/department-search.component';
import {TranslocoModule} from '@ngneat/transloco';
import {NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [DepartmentFormComponent, DepartmentIndexComponent, DepartmentSearchComponent],
  imports: [
    CommonModule,
    DepartmentRoutingModule,
    TranslocoModule,
    NgbPaginationModule,
    FormsModule
  ]
})
export class DepartmentModule { }
