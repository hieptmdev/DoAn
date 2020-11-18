import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainRoutingModule } from './main-routing.module';
import { MainComponent } from './main.component';
import {HeaderComponent} from './share/header/header.component';
import {FooterComponent} from './share/footer/footer.component';
import {MenuComponent} from './share/menu/menu.component';
import {NgbAccordionModule, NgbDropdownModule} from '@ng-bootstrap/ng-bootstrap';
import {PerfectScrollbarModule} from 'ngx-perfect-scrollbar';


@NgModule({
  declarations: [
    MainComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent
  ],
  imports: [
    CommonModule,
    MainRoutingModule,
    NgbDropdownModule,
    NgbAccordionModule,
    PerfectScrollbarModule
  ]
})
export class MainModule { }
