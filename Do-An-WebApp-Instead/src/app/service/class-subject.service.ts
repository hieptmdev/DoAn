import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {ClassSubject} from '../model/class-subject';

@Injectable({
  providedIn: 'root'
})
export class ClassSubjectService extends BaseService{

  constructor(public http: HttpClient) {
    super('classSubject', http);
  }

  public search(data, page, limit): Observable<any>{
    let params;
    if (data){
      params = new HttpParams()
        .set('page', page.toString())
        .set('limit', limit.toString())
        .set('unit', data.csUnit.toString())
        .set('course', data.csCourse.toString())
        .set('code', data.csCode.toString())
        .set('name', data.csName.toString())
        .set('subject', data.csSubject.toString())
        .set('department', data.csDepartment.toString());
    }else {
      params = new HttpParams()
        .set('page', page.toString())
        .set('limit', limit.toString());
    }
    return this.http.get(`${this.url}/search`, {observe: 'response', params})
      .pipe(catchError(err => throwError(err)));
  }

  findById(id): Observable<any>{
    return this.http.get(`${this.url}/${id}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  deleteClassDetailById(id): Observable<any> {
    return this.http.delete(`${this.url}/class-detail/${id}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  deleteMultiClassDetail(classSubject: ClassSubject): Observable<any> {
    return this.http.post(`${this.url}/delete-class-detail`, classSubject, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  transfer(classSubject: ClassSubject, classSubjectId): Observable<any> {
    const params = new HttpParams().set('classSubjectId', classSubjectId);
    return this.http.post(`${this.url}/transfer`, classSubject, {observe: 'response', params})
      .pipe(catchError(err => throwError(err)));
  }

  transferById(classDetailId, classSubjectId): Observable<any> {
    const params = new HttpParams()
      .set('classDetailId', classDetailId)
      .set('classSubjectId', classSubjectId);
    return this.http.put(`${this.url}/transfer`, null, {observe: 'response', params})
      .pipe(catchError(err => throwError(err)));
  }

  findAllClassSameSubject(classSubjectId, subjectId, courseId): Observable<any> {
    const params = new HttpParams()
      .set('classSubjectId', classSubjectId)
      .set('subjectId', subjectId)
      .set('courseId', courseId);
    return this.http.get(`${this.url}/find-all-class-same-subject`, {observe: 'response', params})
      .pipe(catchError(err => throwError(err)));
  }

  saveOrUpdate(classSubject): Observable<any>{
    return this.http.post(`${this.url}`, classSubject, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
