import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-landingpage',
  templateUrl: './landingpage.component.html',
  styleUrls: ['./landingpage.component.scss']
})
export class LandingpageComponent implements OnInit {

  usdinr = true;
  btnname = 'USD';
  courses: any[] = [
    {
      id: 1,
      name: 'Python',
      url: 'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?cs=srgb&dl=pexels-binyamin-mellish-106399.jpg&fm=jpg',
      duration: 2,
      price: 2000,
      startDate: new Date(2021, 2, 10),
      description: 'additional information regarding courses...'
    },
    {
      id: 2,
      name: 'Java',
      url: 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/brewster-mcleod-architects-1486154143.jpg?crop=1.00xw:1.00xh;0,0&resize=980:*',
      duration: 1,
      price: 2000,
      startDate: new Date(2021, 2, 10),
      description: 'additional information regarding courses...'
    },
    {
      id: 3,
      name: 'Angular',
      url: 'https://cf.bstatic.com/images/hotel/max1024x768/137/137262930.jpg',
      duration: 3,
      price: 2000,
      startDate: new Date(2021, 2, 10),
      description: 'additional information regarding courses...'
    },
  ];
  constructor() { }

  ngOnInit(): void {
  }
  toggleUsdInr(): void {
    this.usdinr = !this.usdinr;
    if (this.usdinr) {
      this.btnname = 'USD';
    }
    else {
      this.btnname = 'INR';
    }

  }


}
