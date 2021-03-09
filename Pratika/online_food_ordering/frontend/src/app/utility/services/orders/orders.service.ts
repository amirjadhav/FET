import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import * as config from 'src/assets/config.json';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  config: any;

  constructor(private http: HttpClient) { }
  
  // to get details of delivery person by their id
  getDeliveryPersonDetails(did:number): Observable<any> {
    return this.http.get<any>(`${config.serverUrl}/deliveryPerson/id/${did}`);  
  }

  // to get all orders with specific status 
  getAllOrders(status:string): Observable<any> {
    return this.http.get<any>(`${config.serverUrl}/orders/delivery/${status}`);  
  }

  // to get all orders with status not Cart according to specific delivery-person id
  getOrdersByDid(value:number): Observable<any> {
    return this.http.get<any>(`${config.serverUrl}/orders/did/${value}`);  
  }

  // to get all orders with status not Cart according to specific delivery-person id
  getOrdersByDidStatus(value:number, status:string): Observable<any> {
    return this.http.get<any>(`${config.serverUrl}/orders/did/${value}/${status}`);  
  }

  // to update status of orders once accepted or delivered
  updateDeliveryStatus(id:number,status:string, did: number, otp:number):Observable<any>{
    return this.http.patch<any>(`${config.serverUrl}/orders/${id}`,{"status":status, "did":did,"otp":otp});
  }

  // to send OTP via email to customer
  sendOtpMail(order:any, deliveryperson:any,email:any, otp:number): Observable<any> {
    return this.http.post<any>(`${config.serverUrl}/send`,{"email": email, "restName":order.restaurant.name, "oid": order.oid, "otp":otp, "delName": deliveryperson.username, "vNo": deliveryperson.vehicleno, "amount": order.price, "date": order.orderdate, "time": order.ordertime});  
  }
}
