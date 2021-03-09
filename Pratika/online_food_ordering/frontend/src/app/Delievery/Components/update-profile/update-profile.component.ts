import { Component, OnInit } from '@angular/core';
import { DeliveryProfileService } from 'src/app/utility/services/Delivery/delivery-profile.service';
import { FormControl,FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.scss']
})
//const id=sessionStorage.getItem('id');
export class UpdateProfileComponent implements OnInit {
    DeliveryId:any;
    editProfile=new FormGroup
    ({
      ProfileName:new FormControl('', Validators.pattern("[a-zA-Z][a-zA-Z ]*")),
      ProfileEmail:new FormControl('',[Validators.email,Validators.pattern("[a-zA-Z0-9_\\.\\+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-\\.]+")]),
      ProfilePhone:new FormControl('',Validators.pattern("[0-9]{10}")),
      ProfileAddress:new FormControl(''),
      ProfileVehicle:new FormControl('')
    });

    get ProfileName() {
      return this.editProfile.get('ProfileName')
    }

    get ProfileEmail() {
      return this.editProfile.get('ProfileEmail')
    }

    get ProfilePhone() {
      return this.editProfile.get('ProfilePhone')
    }
 
    constructor(private updateServ:DeliveryProfileService,private _router:Router) 
      {
        this.DeliveryId=sessionStorage.getItem("id");
        if(this.DeliveryId!==null)
          {
            if(sessionStorage.getItem("isUser")==='false')
            {
              this.setProfileData();
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

   setProfileData(){
    this.updateServ.getProfile(this.DeliveryId).subscribe((res)=>{
      this.editProfile.setValue
        ({
          ProfileName:res.username,
          ProfileEmail:res.email,
          ProfileAddress:res.address,
          ProfilePhone:res.contact,
          ProfileVehicle:res.vehicleno
        })
      })
     }

  ngOnInit(): void {}
  /*Updation of User Profile*/
  updateProfile()
  {
    const formData=this.editProfile.value;
    const data={
      
      username:formData.ProfileName,
      contact:formData.ProfilePhone,
      vehicleno:formData.ProfileVehicle,
      address:formData.ProfileAddress,
      email:formData.ProfileEmail

    }
    this.updateServ.updateDeliveryProfile(this.DeliveryId,data).subscribe()
    location.reload();
  }
 
}
