import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment.prod';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  status = ' ';
  constructor(private http: HttpClient) { }

  getUsers(): Observable<any> {
    return this.http.get(environment.baseUserUrl + '/user');
  }
  deleteUser(id: number) {
    console.log(environment.baseUserUrl + 'user/' + id);
    return this.http.delete(environment.baseUserUrl + 'user/' + id).subscribe(() => this.status = 'Delete successful');
  }
}
