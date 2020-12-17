import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class CourseService extends BaseService{

  constructor(public http: HttpClient) {
    super('course', http);
   }

   public getAll(): Observable<any> {
     return this.http.get(`${this.url}/all`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
   }
}
