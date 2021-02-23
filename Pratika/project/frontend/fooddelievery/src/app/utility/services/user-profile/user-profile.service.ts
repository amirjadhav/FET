import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Iuser} from 'src/app/User/interface/iuser'
//userid
var uid=1001
@Injectable({
  providedIn: 'root'
})
export class UserProfileService {
  

  constructor(private _http:HttpClient) 
  {}

    getUserProfile(): Observable<Iuser>
    {
      return this._http.get<Iuser>('http://localhost:7200/user/id/'+uid);
    }
    
    putEditUser(data: any) :Observable<any>
    {
      
      return this._http.put<any>('http://localhost:7200/user/'+uid,data);

    }
    getUserOrder(): Observable<any>

    {

        return this._http.get<any>('http://localhost:7200/orders/uid/'+uid);

    }
    getSpecificUser(id:number): Observable<Iuser>
    {
      return this._http.get<Iuser>('http://localhost:7200/user/id/'+id);
    }

    
}
