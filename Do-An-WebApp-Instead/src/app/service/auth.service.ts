import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService extends BaseService{

  constructor(public http: HttpClient) {
    super('auth', http);
  }

  login(data): Observable<any>{
    return this.http.post(`${this.url}`, data, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
