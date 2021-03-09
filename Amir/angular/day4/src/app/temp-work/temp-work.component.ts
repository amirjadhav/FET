import { Component, OnInit } from '@angular/core';
import { UserService } from '../user-service.service';

@Component({
  selector: 'app-temp-work',
  templateUrl: './temp-work.component.html',
  styleUrls: ['./temp-work.component.scss']
})
export class TempWorkComponent implements OnInit {

  constructor(private us: UserService) { }
  // submitForm(loginForm: any) {
  //   console.log('data coming');
  //   // console.log(loginForm.value.userid);
  //   // console.log(loginForm.value.username);
  //   // console.log(loginForm.value.password);
  //   // console.log(loginForm.value.userrole);



  // }
  submitForm(loginForm: any): void {
    console.log('inside submit form');

    this.us.addUser(loginForm.value).subscribe({
      next: () => { console.log('successfully added record in db'); }
    });
  }
  ngOnInit(): void {
  }

}
