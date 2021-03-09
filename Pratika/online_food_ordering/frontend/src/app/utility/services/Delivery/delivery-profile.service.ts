import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import * as config from 'src/assets/config.json';

@Injectable({
  providedIn: 'root'
})
export class DeliveryProfileService {

  constructor(private delivery:HttpClient) { }
  getProfile(id:number):Observable<any>{
    return this.delivery.get<any>(`${config.serverUrl}/deliveryPerson/id/${id}`);
  }
  updateDeliveryProfile(id:number,data:any):Observable<any>{
    return this.delivery.put<any>(`${config.serverUrl}/deliveryPerson/${id}`,data);
  }
  getOrders(id:number):Observable<any>{
    return this.delivery.get<any>(`${config.serverUrl}/orders/did/${id}`);
  }
  getRestaurant(id:number):Observable<any>{
    return this.delivery.get(`${config.serverUrl}/restaurant/rid/${id}`);
  }
}
