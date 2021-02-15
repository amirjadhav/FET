import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ImageServiceService } from 'src/app/utility/image-service.service';
import { UserService } from 'src/app/utility/user.service';
import { IImage } from '../iimage';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.scss']
})
export class DeleteComponent implements OnInit {
  imageId:number=0;
  images:IImage[];
  index: number=0;

  constructor(around:ActivatedRoute,private fb: FormBuilder,private _imgser:ImageServiceService,private userServ:UserService) {
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

    this._imgser.images.splice(this.index,1)

    this.images.find((img)=>{
      if(img.imgId==this.imageId){
      
      }
    })


    this.userServ.deleteUser().subscribe(()=>{
      console.log("deleted called")
    });
  


  

}
}