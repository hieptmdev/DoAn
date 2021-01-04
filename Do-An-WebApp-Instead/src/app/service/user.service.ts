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
        .set('code', data.empCode.toString())
        .set('name', data.empName.toString())
        .set('username', data.username.toString())
        .set('unit', data.empUnit.toString());
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

  saveOrUpdate(user): Observable<any>{
    return this.http.post(`${this.url}`, user, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  deleteById(id): Observable<any> {
    return this.http.delete(`${this.url}/${id}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  checkPermissionSys(): Observable<any>{
    return this.http.get(`${this.url}/check-permission-sys`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  findAllTeacherByDepartment(departmentId: any): Observable<any> {
    return this.http.get(`${this.url}/all-teacher-by-department/${departmentId}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  findAllTeacher(): Observable<any>{
    return this.http.get(`${this.url}/teachers`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
