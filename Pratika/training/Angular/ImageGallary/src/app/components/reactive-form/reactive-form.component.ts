import { Component, OnInit } from '@angular/core';

import { IImage } from '../iimage';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ImageServiceService } from 'src/app/utility/image-service.service';
@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.scss']
})
export class ReactiveFormComponent implements OnInit {



  images:IImage[];

 imageId:number=0;
 imgName:string='';
 imgSrc:string='';
 imgCategory:string='';
 imgDescription:string='';
 index: number=0;



  // imgForm = new FormGroup({
  //   imgName:new FormControl(this.imgName),
  //   imageSrc:new FormControl(''),
  //   imgCategory:new FormControl(''),
  //   imgDescription:new FormControl(''),
  //   imgId:new FormControl('')
  
  // });


 
 

  imgForm= this.fb.group({
  
    imgName:[""],
    imgSrc:[""],
    imgCategory:[''],
    imgDescription:[''],
    imgId:['']
    })


  newImage:IImage={imgId:this.imageId,imgCategory:this.imgCategory,imgDescription:this.imgDescription,imgName:this.imgName,imgSrc:this.imgSrc};
 
 

update(){


  this.images.find((img)=>{
    if(img.imgId==this.imageId){
      console.log("index"+this.index)
       this._imgser.images.splice(this.index,1,this.imgForm.value)
    }
  })

}

  onSubmit(){
    console.warn(this.imgForm.value);
  }




  constructor(around:ActivatedRoute,private fb: FormBuilder,private _imgser:ImageServiceService) {
    //snapshot
    this.imageId=around.snapshot.params.id
    
     
    //subscribe
          // around.params.subscribe((param)=>{
          //   this.imageId=param.id
          // })


          this.images=this._imgser.images; 
       }
    

  ngOnInit(): void {

    for (var i=0; i<this.images.length; i++) {
      if ( this.images[i].imgId == this.imageId ) {
          this.index = i;
          break;
      }
    }

    this.images.find((img)=>{
      if(img.imgId==this.imageId){
        this.imgName=img.imgName;
        this.imgSrc=img.imgSrc;
        this.imgCategory=img.imgCategory;
        this.imgDescription=img.imgDescription;
      }
    })
  }

}
