import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SubjectService extends BaseService{

  constructor(public http: HttpClient) {
    super('subject', http);
  }

  findAll(): Observable<any> {
    return this.http.get(`${this.url}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  findAllByDepartment(departmentId): Observable<any> {
    return this.http.get(`${this.url}/department/${departmentId}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
