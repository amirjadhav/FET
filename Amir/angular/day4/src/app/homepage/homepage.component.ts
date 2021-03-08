import { Component, OnInit } from '@angular/core';
import { UserService } from '../user-service.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {

  constructor(private us: UserService) { }

  users!: Observable<any>;
  ngOnInit(): void {
    this.us.getUser().subscribe(u => {
      next: () => {
        console.log(u);
      };
    });
  }

}
