import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {StorageService} from '../service/storage.service';
import {JwtHelperService} from '@auth0/angular-jwt';
import {environment} from '../../environments/environment';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private storageService: StorageService,
              private jwtHelperService: JwtHelperService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const  accessToken = this.storageService.getAccessToken();
    if (accessToken == null || this.jwtHelperService.isTokenExpired(accessToken)){
      request = request.clone({
        headers: request.headers
          .set(environment.config.auth.header, environment.config.auth.auth_basic + ' ' + btoa(`${environment.config.auth.client_id}:${environment.config.auth.client_secret}`))
          .set('Content-type', 'application/x-www-form-urlencoded; charset=utf-8')
      });
    }else {
      request = request.clone({
        headers: request.headers
          .set(environment.config.auth.header, environment.config.auth.auth_bearer + ' ' + accessToken)
      });
    }

    return next.handle(request);
  }
}
