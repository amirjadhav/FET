import { IImage } from './../components/iimage';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';





@Injectable({
  providedIn: 'root'
})

export class ImageServiceService {
  images=[
  
    {imgId:101,imgName:'Scenery',imgSrc:'./assets/images/nature.jpg',imgCategory:'Nature',imgDescription:"Beautiful Nature"},
  {imgId:102,imgName:'IPL',imgSrc:'./assets/images/ipl.jpg',imgCategory:'Sport',imgDescription:"sports description"},
  {imgId:103,imgName:'Space',imgSrc:'./assets/images/space.jpg',imgCategory:'Universe',imgDescription:"Beautiful Nature"},
  {imgId:104,imgName:'Island',imgSrc:'./assets/images/island.jpg',imgCategory:'Island',imgDescription:"Beautiful Nature"}
  
  ]
  baseUrl="http://localhost:3000/images";
  constructor(private http:HttpClient) {
   
   }



   getImages():Observable<IImage[]>{
    return this.http.get<IImage[]>(this.baseUrl)
   }



   addImage(person:IImage): Observable<any> {
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(person);
    console.log(body)
    return this.http.post(this.baseUrl, body,{'headers':headers})
  }





 

}
