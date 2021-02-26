import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  name = 'amirjadhav';
  address = 'pune';
  remark = 'This is original msg';

  dob: Date = new Date(1996, 0, 12);

  constructor() { }
  fun1(): any {
    alert('Hello');
  }
  ngOnInit(): void {
  }
  hobby: string[] = ['swimming', 'reading', 'running']
  isvisible: boolean = true;
  showhide() {
    this.isvisible = !this.isvisible;
  }
}
