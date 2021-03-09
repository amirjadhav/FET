import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserSignup } from 'src/app/Shared/interface/user-signup';
import { ApiService } from 'src/app/utility/services/user-login/api.service';
import { AuthService } from 'src/app/utility/services/user-login/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MustMatch } from '../_helpers/must-match.validator';
import { CartService } from 'src/app/utility/services/cart/cart.service';

@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.scss']
})
export class UserSignupComponent implements OnInit {

  isLogin: boolean = false;
  registerForm!: FormGroup;
  submitted = false;
  newUser!: UserSignup;

  constructor(
    private formBuilder: FormBuilder,
    private _api: ApiService,
    private _auth: AuthService,
    private _cartService: CartService
  ) { }

  ngOnInit(): void {
    this.isUserLogin();
    //Form validation
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      phone: ['',[Validators.required, Validators.pattern('[0-9]{10}')] ],
      password: ['', [Validators.required, Validators.pattern('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$')]],
      email: ['', [Validators.required, Validators.email]],
      confirmPassword: ['', Validators.required]
    }, {
      validator: MustMatch('password', 'confirmPassword')
    });

  }

  get f() { return this.registerForm.controls; }

  onSubmit() {
    var formData=this.registerForm.value;
    const newUser={
      username:formData.username,
      email:formData.email,
      password:formData.password,
      phone:formData.phone

    }
    //post user data in database & store values in session storage
    this._api.postTypeRequest('user/register', newUser).subscribe((res: any) => {
      if (res.status !== undefined) {

        this._auth.setDataInSessionStorage('id', res.id);
        this._auth.setDataInSessionStorage('email', formData.email);
        this._auth.setDataInSessionStorage('token', res.token);
        this._auth.setDataInSessionStorage('username', formData.username);
        this._auth.setDataInSessionStorage('isUser', 'true');
        this._cartService.createNewCart({ "uid": res.id }).subscribe();
        this.submitted = true;
        window.location.replace('/');
      } else {
        alert(JSON.stringify(res.error));
      }
    });

   

    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }

}
//check if user logged in
  isUserLogin() {
    if (this._auth.getDataFromSessionStorage('email') != null) {
      this.isLogin = true;
    }
  }

}
