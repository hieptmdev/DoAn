import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService extends BaseService{

  constructor(public http: HttpClient) {
    super('user', http);
  }

  search(data, page, limit): Observable<any> {
    let params;
    if (data){
      params = new HttpParams()
        .set('page', page.toString())
        .set('limit', limit.toString())
        .set('empCode', data.studentCode.toString())
        .set('empName', data.studentName.toString())
        .set('username', data.studentCourse.toString())
        .set('empUnit', data.studentUnit.toString());
    }else {
      params = new HttpParams()
        .set('page', page.toString())
        .set('limit', limit.toString());
    }
    return this.http.get(`${this.url}/search`, {observe: 'response', params})
      .pipe(catchError(err => throwError(err)));
  }

  sendCode(data): Observable<any>{
    return this.http.post(`${this.url}/send-code`, data, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  changePassword(data): Observable<any>{
    return this.http.post(`${this.url}/change-password`, data, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  getUserByUsername(username): Observable<any>{
    return this.http.get(`${this.url}/${username}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  lock(id): Observable<any>{
    return this.http.put(`${this.url}/lock/${id}`, null, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  openLock(id): Observable<any> {
    return this.http.put(`${this.url}/open-lock/${id}`, null, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
