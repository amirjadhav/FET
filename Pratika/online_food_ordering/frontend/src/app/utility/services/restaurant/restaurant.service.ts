import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import * as config from 'src/assets/config.json';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  config: any;

  constructor(private http: HttpClient) {  }
  
  getRestaurants(): Observable<any> {
    return this.http.get<any>(`${config.serverUrl}/restaurant`);
  }

  getSpecificRestaurant(key: string, value: any): Observable<any> {
    return this.http.get<any>(`${config.serverUrl}/restaurant/${key}/${value}`);
  }

  getMenu(key: string, value: any): Observable<any> {
    return this.http.get<any>(`${config.serverUrl}/menu/${key}/${value}`);
  }

  getCategories(): Observable<any> {
    return this.http.get<any>(`${config.serverUrl}/category`);
  }
}
