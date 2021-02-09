import { IImage } from './../iimage';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-image',
  templateUrl: './add-image.component.html',
  styleUrls: ['./add-image.component.scss']
})
export class AddImageComponent implements OnInit {


  newImage:IImage={imgId:101,imgCategory:'',imgDescription:'',imgName:'',imgSrc:''};
 
 
  addImage(imageForm:NgForm){
    alert("image added")
 console.log(imageForm)
  }
  constructor() { }

  ngOnInit(): void {
  }

}
