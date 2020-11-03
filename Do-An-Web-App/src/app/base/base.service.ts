import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BaseService {
  public url: string;

  constructor(public server: string,
              public apiPath: string,
              public httpClient: HttpClient) {
    const SERVER_URL = environment.PREFIX[server];
    const API_PATH = environment.PREFIX.API_PATH[apiPath];
    if (!SERVER_URL) {
      console.error(`Missing config system service config in src/environments/environment.ts => system: ${server}`);
      return;
    }
    if (!API_PATH) {
      console.error(`Missing config system service config in src/app/app-config.ts => module: ${apiPath}`);
      return;
    }
    this.url = SERVER_URL + API_PATH;
  }

  public findAll(page: number, limit: number, data: any): Observable<any>{
   const params = new HttpParams()
     .set('page', page.toString())
     .set('limit', limit.toString());
   const map = new Map(Object.entries(data));
   map.forEach(({value, key}) => {params.set(key.toString(), value === null ? '' : value.toString()); });
   const url = `${this.url}/search`;
   return this.httpClient.get(url, {params});
  }
}
