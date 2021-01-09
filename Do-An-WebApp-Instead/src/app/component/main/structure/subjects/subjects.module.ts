import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SubjectsRoutingModule } from './subjects-routing.module';
import { SubjectsIndexComponent } from './subjects-index/subjects-index.component';
import { SubjectsSearchComponent } from './subjects-search/subjects-search.component';
import { SubjectsFormComponent } from './subjects-form/subjects-form.component';
import {TranslocoModule} from '@ngneat/transloco';
import {FormsModule} from '@angular/forms';
import {NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [SubjectsIndexComponent, SubjectsSearchComponent, SubjectsFormComponent],
  imports: [
    CommonModule,
    SubjectsRoutingModule,
    TranslocoModule,
    FormsModule,
    NgbPaginationModule
  ]
})
export class SubjectsModule { }
