import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {StorageService} from '../services/storage.service';
import {JwtHelperService} from '@auth0/angular-jwt';
import {environment} from '../../environments/environment';

@Injectable()
export class InterceptorConfigInterceptor implements HttpInterceptor {
  token: string;

  constructor(private storageService: StorageService,
              private jwtService: JwtHelperService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    this.token = this.storageService.getAccessToken();
    if (this.token !== null && !this.jwtService.isTokenExpired(this.token, new Date().getTime())){
      request = request.clone({headers: request.headers.set(environment.prefix.auth_header_bearer, this.token)});
    }else {
      request = request.clone({headers: request.headers.set(environment.prefix.auth_header_basic,
          btoa(`${environment.client.id}:${environment.client.secret}`))});
    }
    return next.handle(request);
  }
}
