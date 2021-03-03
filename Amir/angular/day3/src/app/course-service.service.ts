import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
  // instance of this service will be created at the time of creating root module(app)
  // in entire application , only single instance of courseservice will be there
  // singleton design pattern
})
export class CourseService {

  constructor(private http: HttpClient) { }
  getCourses(): Observable<any> {
    return this.http.get('https://jsonplaceholder.typicode.com/posts');
  }
  getCoursesById(id: number): Observable<any> {
    return this.http.get('https://jsonplaceholder.typicode.com/posts/' + id);
  }
  postCourses(): Observable<any> {
    return this.http.post('https://jsonplaceholder.typicode.com/posts',
      { id: 101, name: 'xyz', des: 'description', price: 1234, duration: 2 });
  }
  updateCourses(): Observable<any> {
    return this.http.put('https://jsonplaceholder.typicode.com/posts',
      { id: 101, name: 'xyz', des: 'description', price: 1234, duration: 2 });
  }
  deleteCourses(id: number): Observable<any> {
    return this.http.delete('https://jsonplaceholder.typicode.com/posts/' + id);
  }
}
