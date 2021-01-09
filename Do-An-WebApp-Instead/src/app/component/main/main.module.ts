import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainRoutingModule } from './main-routing.module';
import { StudentComponent } from './student/student.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserComponent } from './user/user.component';
import { ClassSubjectComponent } from './class-subject/class-subject.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SubjectComponent } from './subject/subject.component';
import { NavbarComponent } from './partials/navbar/navbar.component';
import { SidebarComponent } from './partials/sidebar/sidebar.component';
import { FooterComponent } from './partials/footer/footer.component';
import {MainComponent} from './main.component';
import {TranslocoModule} from '@ngneat/transloco';
import { DeleteModalComponent } from './modal/delete-modal/delete-modal.component';
import { TeachComponent } from './teach/teach.component';
import { StructureComponent } from './structure/structure.component';

@NgModule({
    declarations: [
      MainComponent,
      StudentComponent,
      UserProfileComponent,
      UserComponent,
      ClassSubjectComponent,
      DashboardComponent,
      SubjectComponent,
      NavbarComponent,
      SidebarComponent,
      FooterComponent,
      DeleteModalComponent,
      TeachComponent,
      StructureComponent
    ],
    exports: [],
    imports: [
      CommonModule,
      MainRoutingModule,
      TranslocoModule,
    ]
})
export class MainModule { }
