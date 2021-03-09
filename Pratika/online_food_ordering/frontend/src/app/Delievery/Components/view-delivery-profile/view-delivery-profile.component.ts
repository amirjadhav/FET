import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DeliveryProfileService } from 'src/app/utility/services/Delivery/delivery-profile.service';

@Component({
  selector: 'app-view-delivery-profile',
  templateUrl: './view-delivery-profile.component.html',
  styleUrls: ['./view-delivery-profile.component.scss']
})
export class ViewDeliveryProfileComponent implements OnInit {
  ProfileData:any=[];
  DeliveryId:any;
  constructor(private profileserv:DeliveryProfileService,private _router:Router) { 
    this.DeliveryId=sessionStorage.getItem("id")
    if(this.DeliveryId!==null)
    {
      if(sessionStorage.getItem("isUser")==='false')
            {
              this.getProfiledata();
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

  //Get Profile data based on Delivery Id
  getProfiledata()
  {
    this.profileserv.getProfile(this.DeliveryId).subscribe((res)=>{
      this.ProfileData=res;
    })
  }
}
