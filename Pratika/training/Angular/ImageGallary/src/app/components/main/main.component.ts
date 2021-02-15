import { ImageServiceService } from './../../utility/image-service.service';

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

 images:any;


clickFunction(){
alert("button clicked")  
}

  constructor(private imgser:ImageServiceService) {
     // console.log("constructor")
   }
   
  ngOnDestroy(): void {
    //console.log("inside destroy")
  }
  
  ngOnInit(): void {
  //  console.log("inside init")
    this.imgser.getImages().subscribe(data=>{
      this.images=data;
   //   console.log("images"+JSON.stringify(this.images))
    }); 
   
  }

}
