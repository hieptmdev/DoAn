import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CategoryService extends BaseService{

  constructor(public http: HttpClient) {
    super('category', http);
  }

  getParentCategory(roleId): Observable<any>{
    return this.http.get(`${this.url}/${roleId}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  getChildCategory(roleId, parentCategoryId): Observable<any>{
    return this.http.get(`${this.url}/${roleId}/${parentCategoryId}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
