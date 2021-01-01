import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UnitService extends BaseService{

  constructor(public http: HttpClient) {
    super('unit', http);
  }

  public findAllUnit(): Observable<any>{
    return this.http.get(`${this.url}/all-for-student`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
