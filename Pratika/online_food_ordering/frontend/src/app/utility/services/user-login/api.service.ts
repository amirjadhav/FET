import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import * as config from 'src/assets/config.json';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  config: any;

  constructor(private _http: HttpClient) { }

  getTypeRequest(url:any) :Observable<any>{
    return this._http.get<any>(`${config.serverUrl}/${url}`).pipe(map(res => {
      return res;
    }));
  }
  postTypeRequest(url:any, payload:any):Observable<any> {
    return this._http.post<any>(`${config.serverUrl}/${url}`, payload).pipe(map(res => {
      return res;
    }));
  }
  putTypeRequest(url:any, payload:any):Observable<any> {
    return this._http.put<any>(`${config.serverUrl}/${url}`, payload).pipe(map(res => {
      return res;
    }));
  }

}
