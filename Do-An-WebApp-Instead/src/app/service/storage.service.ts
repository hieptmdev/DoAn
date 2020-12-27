import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {LoginForm} from '../model/login-form';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  public rememberLoginInfo(data: LoginForm): void {
    localStorage.setItem(environment.config.prefix.storage.username, data.username);
    localStorage.setItem(environment.config.prefix.storage.password, data.password);
  }

  public getLoginInfo(): LoginForm {
    const form: LoginForm = new LoginForm();
    form.username = localStorage.getItem(environment.config.prefix.storage.username);
    form.password = localStorage.getItem(environment.config.prefix.storage.password);
    return form;
  }
}
