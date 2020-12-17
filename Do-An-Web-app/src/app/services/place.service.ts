import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class PlaceService extends BaseService {

  constructor(public http: HttpClient) { 
    super('place', http);
  }

  public getAllNation(): Observable<any> {
    return this.http.get(`${this.url}/nations`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  public getAllProvince(): Observable<any> {
    return this.http.get(`${this.url}/provinces`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
  public getAllDistrict(): Observable<any> {
    return this.http.get(`${this.url}/districts`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
  public getAllWard(): Observable<any> {
    return this.http.get(`${this.url}/wards`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
