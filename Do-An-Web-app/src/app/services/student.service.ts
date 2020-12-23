import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Student } from '../model/student';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class StudentService extends BaseService {

  constructor(public http: HttpClient) {
    super('student', http);
  }

  search(page, limit, code, name, course, unit): Observable<any> {
    const params = new HttpParams()
      .set('page', page.toString())
      .set('limit', limit.toString())
      .set('code', code)
      .set('name', name)
      .set('course', course)
      .set('unit', unit);
    return this.http.get(`${this.url}/search`, {observe: 'response', params})
      .pipe(catchError(err => throwError(err)));
  }

  findByCode(code): Observable<any> {
    return this.http.get(`${this.url}/code/${code}`, {observe: 'response'})
    .pipe(catchError(err => throwError(err)));
  }

  findAllScoreByStudentCode(code): Observable<any> {
    return this.http.get(`${this.url}/score/${code}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  save(student: Student): Observable<any> {
    return this.http.post(`${this.url}/add`, student, {observe: 'response'})
    .pipe(catchError(err => throwError(err)));
  }

  update(student: Student): Observable<any> {
    return this.http.post(`${this.url}/update`, student, {observe: 'response'})
    .pipe(catchError(err => throwError(err)));
  }
}
