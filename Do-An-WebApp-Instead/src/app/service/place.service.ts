import { Injectable } from '@angular/core';
import {BaseService} from './base.service';
import {HttpClient} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PlaceService extends BaseService{

  constructor(public http: HttpClient) {
    super('place', http);
  }

  findAllNation(): Observable<any>{
    return this.http.get(`${this.url}/nations`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  findAllProvince(): Observable<any>{
    return this.http.get(`${this.url}/provinces`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  findAllDistrict(): Observable<any>{
    return this.http.get(`${this.url}/districts`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  findAllDistrictByProvince(provinceId): Observable<any>{
    return this.http.get(`${this.url}/districts/${provinceId}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  findAllWard(): Observable<any> {
    return this.http.get(`${this.url}/wards`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }

  findAllWardByProvinceAndDistrict(provinceId, districtId): Observable<any> {
    return this.http.get(`${this.url}/wards/${provinceId}/${districtId}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
  }
}
