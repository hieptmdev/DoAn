import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

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
}
