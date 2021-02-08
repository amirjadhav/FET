import { IImage } from './../iimage';
import { Component, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit,OnDestroy {

  today= new Date(); 
  search: any = '';
  current_cart_count=0;
  onClick_button($event:any){}


images:IImage[]=[
  
  {imgId:101,imgName:'Scenery',imgSrc:'./assets/images/nature.jpg',imgCategory:'Nature',imgDescription:"Beautiful Nature"},
{imgId:102,imgName:'IPL',imgSrc:'./assets/images/ipl.jpg',imgCategory:'Sport',imgDescription:"sports description"},
{imgId:103,imgName:'Space',imgSrc:'./assets/images/space.jpg',imgCategory:'Universe',imgDescription:"Beautiful Nature"},
{imgId:104,imgName:'Island',imgSrc:'./assets/images/island.jpg',imgCategory:'Island',imgDescription:"Beautiful Nature"}

]

clickFunction(){
alert("button clicked")  
}

  constructor() {
    console.log("inside constructor")
   }
  ngOnDestroy(): void {
    console.log("inside destroy")
  }
  
  ngOnInit(): void {
    console.log("inside init")
  }

}
