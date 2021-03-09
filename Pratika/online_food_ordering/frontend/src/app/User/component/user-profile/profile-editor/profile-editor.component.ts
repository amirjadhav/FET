import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, Validators } from '@angular/forms';
import { UserProfileService } from 'src/app/utility/services/user-profile/user-profile.service'
import { Iuser} from 'src/app/User/interface/iuser'

@Component({
  selector: 'app-profile-editor',
  templateUrl: './profile-editor.component.html',
  styleUrls: ['./profile-editor.component.scss']
})
export class ProfileEditorComponent implements OnInit {
  uid:any =sessionStorage.getItem("id");
  user: Iuser= {
    userid: 0,username: "",email: "",phone: 0 ,image : "",address: []
  };

  editForm = new FormGroup({
   uname : new FormControl('',Validators.pattern("[a-zA-Z][a-zA-Z ]*")),
   uemail: new FormControl('',Validators.email),
   uphone: new FormControl('',Validators.pattern("[0-9]{10}"))
  });
  
  get uname(){
    return this.editForm.get('uname');
  }

  get uemail(){
    return this.editForm.get('uemail');
  }

  get uphone(){
    return this.editForm.get('uphone');
  }

  constructor(private _userform: UserProfileService) {

    this._userform.getUserProfile(this.uid).subscribe((res)=>{
     this.user =res;   
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
    })
  }

  onSubmit(){
    let formdata = this.editForm.value
       const newUser = {
          username : formdata.uname,
          email : formdata.uemail,
          phone : formdata.uphone,
         
        }
    this._userform.putEditUser(newUser,this.uid).subscribe(
    );
    location.reload();
  }

}
