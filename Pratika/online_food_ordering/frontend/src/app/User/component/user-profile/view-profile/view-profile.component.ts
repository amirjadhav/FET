import { Component, OnInit } from '@angular/core';
import { UserProfileService } from 'src/app/utility/services/user-profile/user-profile.service'
import { EventEmitter,Output} from '@angular/core';
@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.scss']
})
export class ViewProfileComponent implements OnInit {
  uid:any= sessionStorage.getItem("id");
  userprofile:any=[];
  

  @Output() sendAddressIndex : EventEmitter <number> = new EventEmitter<number>();
  @Output()  deleteAddressIndex : EventEmitter <number> = new EventEmitter<number>();

  public updateAddress(index :number ) {  
    this.sendAddressIndex.emit(index);
  
  };
  public deleteAddress(dindex :number ) {  
    this.deleteAddressIndex.emit(dindex);
  };

  constructor(private _userProfileService: UserProfileService) { 
   
    this._userProfileService.getUserProfile(this.uid).subscribe((res)=>{
     this.userprofile=res;
    
    })

  }

  ngOnInit(): void {
  }

}
