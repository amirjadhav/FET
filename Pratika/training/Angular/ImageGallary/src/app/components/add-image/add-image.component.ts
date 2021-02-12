import { IImage } from './../iimage';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { ImageServiceService } from 'src/app/utility/image-service.service';

@Component({
  selector: 'app-add-image',
  templateUrl: './add-image.component.html',
  styleUrls: ['./add-image.component.scss']
})
export class AddImageComponent implements OnInit {
  imgName=new FormControl('');
   
   index=0;
  newImage={imgId:101,imgCategory:'',imgDescription:'',imgName:'',imgSrc:''};
 
 
  addImage(imageForm:NgForm){
    alert("image added")




      this.imgser.addImage(this.newImage)
        .subscribe(data => {
          console.log("data to post"+data)
        
        })      
  


    this.imgser.images.push(this.newImage)
 console.log(imageForm)
  }
  constructor(private imgser:ImageServiceService) {

    this.index=this.imgser.images.length;
    console.log("index"+this.index)
   }

  ngOnInit(): void {
  }

}
