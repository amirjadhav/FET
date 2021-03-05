import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user-service.service';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.scss']
})
export class ReactiveFormComponent implements OnInit {


  registerForm!: FormGroup;

  constructor(private us: UserService) { }

  ngOnInit() {
    this.registerForm = new FormGroup({
      id: new FormControl('101', Validators.required),
      name: new FormControl(),
      password: new FormControl(),
      role: new FormControl()
    });
  }

  registerUser() {
    console.log(this.registerForm);
    this.us.addUser(this.registerForm.value).subscribe({
      next: () => { console.log("user added") }
    });
  }

}
