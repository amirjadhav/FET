import { Component, OnInit } from '@angular/core';
import { UserProfileService } from 'src/app/utility/services/user-profile/user-profile.service'

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.scss']
})
export class ViewProfileComponent implements OnInit {

  userprofile:any=[];


  constructor(private _userProfileService: UserProfileService) { 
   
    this._userProfileService.getUserProfile().subscribe((res)=>{
     this.userprofile=res;
     //console.log(this.userprofile);
    })

  }

  ngOnInit(): void {
  }

}
