import { Injectable } from '@angular/core';
import {HttpRequest, HttpHandler, HttpEvent, HttpInterceptor} from '@angular/common/http';
import { Observable } from 'rxjs';
import {StorageService} from '../../services/storage.service';
import {JwtHelperService} from '@auth0/angular-jwt';
import {environment} from '../../../environments/environment';

@Injectable()
export class ConfigInterceptor implements HttpInterceptor {

  constructor(private storageService: StorageService,
              private jwtService: JwtHelperService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const accessToken = this.storageService.getAccessToken();
    const refreshToken = this.storageService.getRefreshToken();
    if (accessToken !== null && !this.jwtService.isTokenExpired()) {
      request = request.clone({headers: request.headers.set(environment.PREFIX.HEADER_AUTH,
          environment.PREFIX.AUTH_BEARER + ' ' + accessToken)});
    }
    if (accessToken === null || (this.jwtService.isTokenExpired() && !this.jwtService.isTokenExpired(refreshToken))){
      request = request.clone({headers: request.headers.set(environment.PREFIX.HEADER_AUTH,
          environment.PREFIX.AUTH_BASIC + ' ' + btoa(`${environment.CLIENT.ID}:${environment.CLIENT.SECRET}`))});
    }
    return next.handle(request);
  }
}
