import { Component, OnInit } from '@angular/core';
import { UserProfileService } from 'src/app/utility/services/user-profile/user-profile.service'

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  user:any=[];

  constructor(private _userService: UserProfileService) { 
    this._userService.getUserProfile().subscribe((res)=>{
      this.user=res;
     // console.log(this.user);

  });
  }

  ngOnInit(): void {
  }

}
