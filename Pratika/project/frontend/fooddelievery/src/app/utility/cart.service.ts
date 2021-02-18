import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  items = [];
  baseUrl="http://localhost:7200";
  constructor( private http: HttpClient) { }

  
  getCartItems():Observable<any[]>{
    return this.http.get<any[]>(this.baseUrl+'/cart')
   }

}
