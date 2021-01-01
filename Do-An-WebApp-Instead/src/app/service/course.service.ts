import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CourseService extends BaseService{

  constructor(public http: HttpClient) {
    super('course', http);
  }

  public findAll(): Observable<any>{
    return this.http.get(`${this.url}/all`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
