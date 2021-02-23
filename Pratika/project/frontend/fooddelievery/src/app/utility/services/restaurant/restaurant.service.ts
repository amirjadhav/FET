import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  constructor(private http: HttpClient) { }
  
  getData(): Observable<any> {
    return this.http.get<any>('http://localhost:7200/restaurant');
  }

  /*addImage(image: IImage): Observable<any> {
    return this.http.post<any>('http://localhost:3000/images', image);
  }

  editImage(id: number, image: IImage): Observable<any> {
    return this.http.patch<any>(`http://localhost:3000/images/${id}`, image);
  }

  deleteImage(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:3000/images/${id}`);
  }*/
}
