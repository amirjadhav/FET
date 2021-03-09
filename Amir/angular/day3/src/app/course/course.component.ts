import { Component, OnInit, ViewChild } from '@angular/core';
import { Course } from '../course';
import { CoursedetailsComponent } from '../coursedetails/coursedetails.component';
import { CourseService } from '../course-service.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.scss']
})
export class CourseComponent implements OnInit {
  coursesList: Observable<any>;
  constructor(private cs: CourseService) { // it will create courseservice dependancy and only one copy is created as angular use singleton pattern

    this.coursesList = cs.getCourses();
  }


  // @ViewChild(CoursedetailsComponent, { static: false }) vc: CoursedetailsComponent ;

  handleChildEvent(dt: any): any {
    console.log('data received from child : ' + dt);
  }

  ngOnInit(): void {
  }

}


