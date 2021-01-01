import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class StudentService extends BaseService{

  constructor(public http: HttpClient) {
    super('student', http);
  }

  public search(data: any, page, limit): Observable<any> {
    let params;
    if (data){
      params = new HttpParams()
        .set('page', page.toString())
        .set('limit', limit.toString())
        .set('code', data.studentCode.toString())
        .set('name', data.studentName.toString())
        .set('course', data.studentCourse.toString())
        .set('unit', data.studentUnit.toString());
    }else {
      params = new HttpParams()
        .set('page', page.toString())
        .set('limit', limit.toString());
    }
    return this.http.get(`${this.url}/search`, {observe: 'response', params})
      .pipe(catchError(err => throwError(err)));
  }

  public deleteById(studentId): Observable<any>{
    return this.http.delete(`${this.url}/${studentId}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  public findStudentByCode(code: any): Observable<any> {
    return this.http.get(`${this.url}/code/${code}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  public saveOrUpdate(student): Observable<any>{
    return this.http.post(`${this.url}`, student, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  public findAllScoreByStudentCode(code): Observable<any>{
    return this.http.get(`${this.url}/score/${code}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
