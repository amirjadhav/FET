import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-coursedetails',
  templateUrl: './coursedetails.component.html',
  styleUrls: ['./coursedetails.component.scss']
})
export class CoursedetailsComponent implements OnInit {

  @Input() mycourses: any

  constructor() { }



  @Output() childDataEm: EventEmitter<number> = new EventEmitter();

  childData = 123;
  temp = 0;
  sendDataToParent() {
    //i will write code to send data to parent
    this.childDataEm.emit(this.childData);
  }

  ngOnInit() {
  }
}
