import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService extends BaseService{

  constructor(public http: HttpClient) {
    super('auth', http);
  }

  login(data): Observable<any>{
    const params = new URLSearchParams();
    params.append('grant_type', environment.config.auth.grant_type_password);
    params.append('username', data.username);
    params.append('password', data.password);
    return this.http.post(`${this.url}`, params.toString(), {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
