import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService extends BaseService{

  constructor(public http: HttpClient) {
    super('department', http);
  }

  findAll(): Observable<any> {
    return this.http.get(`${this.url}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  findAllByUnit(unitId): Observable<any> {
    return this.http.get(`${this.url}/unit/${unitId}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
