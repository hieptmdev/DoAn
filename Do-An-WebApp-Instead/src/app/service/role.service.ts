import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RoleService extends BaseService{

  constructor(public http: HttpClient) {
    super('role', http)
  }

  findAllRole(): Observable<any> {
    return this.http.get(`${this.url}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
