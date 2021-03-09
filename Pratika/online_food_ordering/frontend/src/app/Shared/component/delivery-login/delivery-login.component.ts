import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ApiService } from 'src/app/utility/services/user-login/api.service'
import { AuthService } from 'src/app/utility/services/user-login/auth.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-delivery-login',
  templateUrl: './delivery-login.component.html',
  styleUrls: ['./delivery-login.component.scss']
})
export class DeliveryLoginComponent implements OnInit {
  isLogin: boolean = false;
  errorMessage: boolean = false;

  constructor(
    private _api: ApiService,
    private _auth: AuthService,
    private _router: Router
  ) { }

  ngOnInit(): void {
    this.isUserLogin();
  }
  
  onSubmit(form: NgForm) {
    this._api.postTypeRequest('deliveryPerson/login', form.value).subscribe((res: any) => {
      if (res.status !== undefined) {
        this._auth.setDataInSessionStorage('id', res.id);
        this._auth.setDataInSessionStorage('email', form.value.email);
        this._auth.setDataInSessionStorage('token', res.token);
        this._auth.setDataInSessionStorage('username', res.username);
        this._auth.setDataInSessionStorage('isUser', 'false');
        window.location.replace('delivery');
        
      }
      else {
        this.errorMessage=true;
      }
    });
  }
  
  isUserLogin() {
    console.log(this._auth.getDataFromSessionStorage('email'))
    if (this._auth.getDataFromSessionStorage('email') != null) {
      this.isLogin = true;
    }
  }

  logout() {
    this._auth.clearStorage()
    this._router.navigate(['/']);
  }

}
