import { UserService } from '../../utility/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  users:any[]=[]

  constructor(private userServ:UserService) { }

  ngOnInit(): void {
    this.userServ.getUsers().subscribe((res:any)=>{
      const {data}=res;
      this.users=data
    });
  }

}
