import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MustMatch } from '../_helpers/must-match.validator';
import { DeliverySignup } from 'src/app/Shared/interface/delivery-signup';
import { ApiService } from 'src/app/utility/services/user-login/api.service';
import { AuthService } from 'src/app/utility/services/user-login/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delivery-signup',
  templateUrl: './delivery-signup.component.html',
  styleUrls: ['./delivery-signup.component.scss']
})
export class DeliverySignupComponent implements OnInit {

  registerForm!: FormGroup;
  submitted = false;
  isLogin: boolean = false;
  newDelivery!: DeliverySignup;

  constructor(
    private formBuilder: FormBuilder,
    private _api: ApiService,
    private _auth: AuthService,
    private _router: Router
  ) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({

      //Form validations
      username: ['', Validators.required],
      contact: ['', [Validators.required, Validators.pattern('[0-9]{10}')]],
      vehicleno: ['', [Validators.required,Validators.pattern('^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$')]],
      address: ['', Validators.required],
      password: ['', [Validators.required, Validators.pattern('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$')]],
      email: ['', [Validators.required, Validators.email]],
      confirmPassword: ['', Validators.required]
    }, {
      validator: MustMatch('password', 'confirmPassword')
    });
    this.isUserLogin();
  }

  get f() { return this.registerForm.controls; }

  onSubmit() {
    var formData = this.registerForm.value;
    const newDelivery = {
      username: formData.username,
      contact: formData.contact,
      vehicleno: formData.vehicleno,
      address: formData.address,
      password: formData.password,
      email: formData.email

    }
    //post delivery person data in database & store values in session storage
    this._api.postTypeRequest('deliveryPerson/register', newDelivery).subscribe((res: any) => {
      if (res.status !== undefined) {
        this._auth.setDataInSessionStorage('id', res.id);
        this._auth.setDataInSessionStorage('email', res.email);
        this._auth.setDataInSessionStorage('token', res.token);
        this._auth.setDataInSessionStorage('username', formData.username);
        this._auth.setDataInSessionStorage('isUser', 'false');
        window.location.replace('/delivery');
      } else {
        alert(JSON.stringify(res.error));
      }
    });

    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

  }
  //check if logged in
  isUserLogin() {
    if (this._auth.getDataFromSessionStorage('email') != null) {
      this.isLogin = true;
    }
  }

}
