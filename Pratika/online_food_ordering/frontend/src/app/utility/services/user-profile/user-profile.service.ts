import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Iuser} from 'src/app/User/interface/iuser';
import * as config from 'src/assets/config.json';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {
  

  constructor(private _http:HttpClient) 
  {}

    getUserProfile(uid: number): Observable<Iuser>
    {
    return this._http.get<Iuser>(`${config.serverUrl}/user/id/${uid}`);
    }
    

    putEditUser(data: any , uid: number) :Observable<any>
    {
    return this._http.put<any>(`${config.serverUrl}/user/${uid}`,data);
    }


    getUserOrder(uid: number): Observable<any>
    {
    return this._http.get<any>(`${config.serverUrl}/orders/uid/${uid}`);
    }


    patchUpdateAdress(id: any, data: any): Observable<any>
    {
    return this._http.patch<any>(`${config.serverUrl}/address/${id}`, data);
    }

    deleteAddress(id : any): Observable<any>
    {
    return this._http.delete<any>(`${config.serverUrl}/address/${id}`);
    }
    
    getSpecificUser(id:number): Observable<Iuser>
    {
      return this._http.get<Iuser>(`${config.serverUrl}/user/id/${id}`);
    }

    
    addAddress(id : any,data : any):Observable<any>
    {
    return this._http.post<any>(`${config.serverUrl}/address/${id}`, data);
    }

    getRestaurantDetails(id : any):Observable<any>
    { 
      return this._http.get<any>(`${config.serverUrl}/restaurant/rid/${id}`);

    }

    getAllOrders():Observable<any>
    {

      return this._http.get<any>(`${config.serverUrl}/orders/all`);
    }

    updateOrder(oid: number, data: any):Observable<any>
    {
      return this._http.put<any>(`${config.serverUrl}/orders/${oid}`, data);
    }

    updateDeliveryRating(did : number ,data :any):Observable<any>
    {
      return this._http.put<any>(`${config.serverUrl}/deliveryPerson/rating/${did}`,data);
    }

    updateRestaurantRating(rid :number ,data:any):Observable<any>
    {
      return this._http.put<any>(`${config.serverUrl}/restaurant/rating/${rid}`,data);
    }
}
