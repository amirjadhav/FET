import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import * as config from 'src/assets/config.json';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  config: any;
  constructor( private http: HttpClient) { }
  
  getCartItems(uid:number):Observable<any>{
    return this.http.get<any>(config.serverUrl+'/cart/'+uid)
   }

   deleteItem(oid:number,mid:number):Observable<any>{
    return this.http.delete<any>(`${config.serverUrl}/orderitems/${oid}/${mid}`)
   }

  updateQuantity(oid:number,mid:number,quantity:number):Observable<any>{
   return this.http.patch<any>(`${config.serverUrl}/orderitems/${oid}/${mid}`,{"quantity":quantity})
  }

  updateStatus(id:number,data:any):Observable<any>{

    return this.http.patch<any>(config.serverUrl+'/orders/'+id,data)
   }
 
   createItems(data:any):Observable<any>{
    return this.http.post<any>(config.serverUrl+'/orderitems',data)
   }

    createNewCart(data:any):Observable<any>{
    return this.http.post<any>(config.serverUrl+'/orders',data)
   }
   
   updateCart(id: number, data: any):Observable<any>{
    return this.http.patch<any>(`${config.serverUrl}/orders/${id}`, data)
  }
 
}
