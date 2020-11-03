import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  public rememberLogin(data: any): void{
    localStorage.setItem(environment.PREFIX.STORAGE.REMEMBER_USERNAME, data.username);
    localStorage.setItem(environment.PREFIX.STORAGE.REMEMBER_PASSWORD, data.password);
  }

  public saveToken(data: any): void{
    localStorage.setItem(environment.PREFIX.STORAGE.ACCESS_TOKEN, data.access_token);
    localStorage.setItem(environment.PREFIX.STORAGE.REFRESH_TOKEN, data.refresh_token);
  }

  public removeToken(): void{
    localStorage.removeItem(environment.PREFIX.STORAGE.ACCESS_TOKEN);
    localStorage.removeItem(environment.PREFIX.STORAGE.REFRESH_TOKEN);
  }

  public getAccessToken(): string{
    return localStorage.getItem(environment.PREFIX.STORAGE.ACCESS_TOKEN);
  }

  public getRefreshToken(): string{
    return localStorage.getItem(environment.PREFIX.STORAGE.REFRESH_TOKEN);
  }
}
