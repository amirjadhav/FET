import { Component , OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DeliveryProfileService } from 'src/app/utility/services/Delivery/delivery-profile.service';

@Component({
  selector: 'app-delivery-profile',
  templateUrl: './delivery-profile.component.html',
  styleUrls: ['./delivery-profile.component.scss']
})
export class DeliveryProfileComponent implements OnInit {
 Executive:any=[];
 orderDetails:any;
 AvgRating:number=0;
 ratings:any[]=[];
 DeliveryId:any;
  sum: number = 0;
  constructor(private _profileserv:DeliveryProfileService,private _router:Router) 
  {
    this.DeliveryId=sessionStorage.getItem("id");
    if(this.DeliveryId!=null)
    {
      if(sessionStorage.getItem("isUser")==='false')
      {
        this.getAverageRatings();
      }
      else
      {
        this._router.navigate(['**']);
      }  
    }
    else
    {
      this._router.navigate(['deliveryLogin']);
    }
  }
  
  ngOnInit(): void {
    
  }

  //Average ratings for Executive
 getAverageRatings(){
  this._profileserv.getProfile(this.DeliveryId).subscribe((res)=>{
    this.Executive=res;
    })
  }
 
}
