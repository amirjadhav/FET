import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.scss']
})
export class UserSignupComponent implements OnInit {

  username='';
  email='';
  password='';
  cpassword='';
  phone='';

  constructor() { }

  ngOnInit(): void {
  }
  addUser(form:NgForm): void{
    console.log(form.value.username);
  }

}
