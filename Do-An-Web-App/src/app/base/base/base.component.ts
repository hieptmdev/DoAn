import { Component, OnInit } from '@angular/core';
import {ConfigActions} from '../../theme-options/config.actions';
import {Observable} from 'rxjs';
import {ThemeOptions} from '../../theme-options';
import {select} from '@angular-redux/store';
import {animate, query, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-base',
  templateUrl: './base.component.html',
  styleUrls: ['./base.component.css'],
  animations: [
    trigger('architectUIAnimation', [
      transition('* <=> *', [
        query(':enter, :leave', [
          style({
            opacity: 0,
            display: 'flex',
            flex: '1',
            transform: 'translateY(-20px)',
            flexDirection: 'column'
          }),
        ]),
        query(':enter', [
          animate('600ms ease', style({opacity: 1, transform: 'translateY(0)'})),
        ]),

        query(':leave', [
          animate('600ms ease', style({opacity: 0, transform: 'translateY(-20px)'})),
        ], { optional: true })
      ]),
    ])
  ]
})
export class BaseComponent implements OnInit {

  @select('config') public config$: Observable<any>;

  constructor(public globals: ThemeOptions, public configActions: ConfigActions) { }

  ngOnInit(): void { }

  public toggleSidebarMobile(): void {
    this.globals.toggleSidebarMobile = !this.globals.toggleSidebarMobile;
  }
}
