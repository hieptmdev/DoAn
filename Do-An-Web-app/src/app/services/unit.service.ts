import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class UnitService extends BaseService{

  constructor(public http: HttpClient) {
    super('unit', http);
   }

   public findAllForStudent(unitId): Observable<any> {
     return this.http.get(`${this.url}/all-for-student/${unitId}`, {observe: 'response'})
      .pipe(catchError(err => throwError(err)));
   }
}
