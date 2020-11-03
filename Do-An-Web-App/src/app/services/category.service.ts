import { Injectable } from '@angular/core';
import {BaseService} from '../base/base.service';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService extends BaseService{

  constructor(public httpClient: HttpClient) {
    super('SERVER_LOCAL', 'category', httpClient);
  }
}
