import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TeachRoutingModule } from './teach-routing.module';
import { TeachIndexComponent } from './teach-index/teach-index.component';
import { TeachSearchComponent } from './teach-search/teach-search.component';
import { TeachFormComponent } from './teach-form/teach-form.component';
import {TranslocoModule} from '@ngneat/transloco';
import {NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [TeachIndexComponent, TeachSearchComponent, TeachFormComponent],
  imports: [
    CommonModule,
    TeachRoutingModule,
    TranslocoModule,
    NgbPaginationModule,
    FormsModule
  ]
})
export class TeachModule { }
