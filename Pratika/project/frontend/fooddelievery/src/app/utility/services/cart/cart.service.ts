import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
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

   deleteItem(id:number):Observable<any[]>{
    return this.http.delete<any[]>(this.baseUrl+'/orderitems/'+id)
   }

  updateQuantity(id:number,quantity:number):Observable<any>{
   return this.http.patch<any>(this.baseUrl+'/orderitems/'+id,{"quantity":quantity})
  }

  updateStatus(id:number,time:string,date:string,totalAmount:number,status:string):Observable<any>{
    return this.http.patch<any>(this.baseUrl+'/orders/'+id,{"ordertime":time, "orderdate":date,"price":totalAmount,"status":status})
   }
 

   deleteAllItem(id:number):Observable<any[]>{
    return this.http.delete<any[]>(this.baseUrl+'/orderitems/all/'+id)
   }


}
