import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BaseService {
  url: string;

  constructor(public apiPath: string, public http: HttpClient) {
    this.url = environment.server.local + environment.api[apiPath];
  }
}
