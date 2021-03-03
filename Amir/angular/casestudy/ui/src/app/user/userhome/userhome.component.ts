import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from '../../user.service';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.scss']
})
export class UserhomeComponent implements OnInit {

  users: Observable<any>;
  constructor(private us: UserService) {
    this.users = this.us.getUsers();
  }
  updateUser(id: number) {

  }
  deleteUser(id: number) {
    console.log(id);
    this.us.deleteUser(id);
  }
  ngOnInit(): void {
  }

}
