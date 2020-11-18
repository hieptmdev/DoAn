import { Injectable } from '@angular/core';
import {Observable, throwError} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService extends BaseService{

  constructor(public http: HttpClient) {
    super('user', http);
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
}
