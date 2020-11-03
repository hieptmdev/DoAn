import { Injectable } from '@angular/core';
import {BaseService} from '../base/base.service';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService extends BaseService{

  constructor(public httpClient: HttpClient) {
    super('SERVER_LOCAL', 'user', httpClient);
  }
}
