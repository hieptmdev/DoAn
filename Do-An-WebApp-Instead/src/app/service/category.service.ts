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

  getParentCategory(): Observable<any>{
    return this.http.get(`${this.url}/parent`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  getChildCategory(parentCategoryId): Observable<any>{
    return this.http.get(`${this.url}/child/${parentCategoryId}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
