import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ImageServiceService } from 'src/app/utility/image-service.service';
import { IImage } from '../iimage';

@Component({
  selector: 'app-image-details',
  templateUrl: './image-details.component.html',
  styleUrls: ['./image-details.component.scss']
})
export class ImageDetailsComponent implements OnInit {

  images:IImage[];

  


 imageId:number=0;
 imgName:string='';
 imgSrc:string='';
 imgCategory:string='';
 imgDescription:string='';
 
  constructor(around:ActivatedRoute, private _imgser:ImageServiceService) {
//snapshot
this.imageId=around.snapshot.params.id

 
//subscribe
      // around.params.subscribe((param)=>{
      //   this.imageId=param.id
      // })

      this.images=this._imgser.images;
   }


  
   
  ngOnInit(): void {


    this.images.find((img)=>{
      if(img.imgId==this.imageId){
        this.imgName=img.imgName;
        this.imgSrc=img.imgSrc;
        this.imgCategory=img.imgCategory;
        this.imgDescription=img.imgDescription
      }
    })

  }

}
