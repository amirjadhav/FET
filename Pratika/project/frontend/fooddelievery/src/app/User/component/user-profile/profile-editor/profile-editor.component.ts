import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule } from '@angular/forms';
import { UserProfileService } from 'src/app/utility/services/user-profile/user-profile.service'
import { Iuser} from 'src/app/User/interface/iuser'


@Component({
  selector: 'app-profile-editor',
  templateUrl: './profile-editor.component.html',
  styleUrls: ['./profile-editor.component.scss']
})
export class ProfileEditorComponent implements OnInit {

  user: Iuser= {
    userid: 0,username: "",email: "",phone: 0 ,image : "",address: []

  };

  editForm = new FormGroup({
   uname : new FormControl(''),
   uemail: new FormControl(''),
   uphone: new FormControl(''),
   uimg : new FormControl(''),
   uaddress: new FormControl(''),
  });
  constructor(private _userform: UserProfileService) {

    this._userform.getUserProfile().subscribe((res)=>{
     this.user =res;
     // console.log(JSON.stringify(this._userform));

      this.updateform();
     });

   }

  ngOnInit(): void {

  }

  updateform()
  {
    this.editForm.patchValue({
      uname : this.user?.username,
      uemail: this.user?.email,
      uphone: this.user?.phone,
      uimg :  this.user?.image,
      uaddress:  this.user.address[0].address
    })

  

  }

  onSubmit(){
    let formdata = this.editForm.value
   
      
       const newUser = {
          username : formdata.uname,
          email : formdata.uemail,
          phone : formdata.uphone,
          image : formdata.uimg
          
        }
       // console.log(newUser);
    this._userform.putEditUser(newUser).subscribe(
     
    )

    alert("user updated");
    location.reload();
  }

}
