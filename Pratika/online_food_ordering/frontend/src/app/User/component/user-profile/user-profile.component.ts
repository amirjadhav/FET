import { Component, OnInit} from '@angular/core';
import { UserProfileService } from 'src/app/utility/services/user-profile/user-profile.service'
import { FormControl, FormGroup, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
 uid:any=sessionStorage.getItem("id");
//to get user object
  user:any=[];
  userOrder: any=[];
  currentOrderDetails: any;

  addressId: number=0;
  //editAddress form
  editAddress = new FormGroup({
    editAddressName: new FormControl(''),
    editAddressType: new FormControl('')
   });



   //newAddress form 
   newAddress = new FormGroup
   ({
     newAddressName: new FormControl(''),
     newAddressType: new FormControl('')
   })

  //orderDetail form

    

  constructor(private _userService: UserProfileService,private _userOrderService: UserProfileService,private _router:Router) { 
   
      if(this.uid!==null){
       if(sessionStorage.getItem("isUser")==="true"){
        this._userService.getUserProfile(this.uid).subscribe((res)=>{
          this.user=res;
        }); 
       }
       else {
         this._router.navigate(['**']);
       }
      } 
      else{
       this._router.navigate(['userLogin']);
      } 
      
     
  }


  ngOnInit(): void {
    
    this._userOrderService.getUserOrder(this.uid).subscribe((res)=>{
      this.userOrder=res;
      
  this.userOrder.forEach((order:any) => {
    this._userOrderService.getRestaurantDetails(order.rid).subscribe((res)=>{
      order["Restaurant"]=res; 
    });
   })
  })
}



//patching address of address editor modal
  updateAddressForm(index: number){
     this.editAddress.patchValue ({
      editAddressType : this.user.address[index].type,
      editAddressName: this.user.address[index].address,
    })
    this.addressId=this.user.address[index].id;
  }




//submit button to submit a edited address
  onEditAddressSubmit(){
  
    let formAddress = this.editAddress.value
    this._userService.patchUpdateAdress(this.addressId, {
      type: formAddress.editAddressType,
      address: formAddress.editAddressName
    }).subscribe();
    location.reload();
  }


  //delete function to delete a specific address

  deleteAddressForm(dindex :number){
    this._userService.deleteAddress(this.user.address[dindex].id).subscribe();
    location.reload();
   }

 //new Address modal submit button functionality
 SaveNewAddress(){ 
    
     let SaveAddress = this.newAddress.value;

     this._userService.addAddress(this.user.userid, {
       
      address :SaveAddress.newAddressName,
      type :  SaveAddress.newAddressType
     
     }
      ).subscribe();
      
       location.reload();
   }

   //for order details modal

   updateOrderDetail(index : number){ 
   this.currentOrderDetails=this.userOrder[index];
   }
   
}


