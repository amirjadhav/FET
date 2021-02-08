import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class Actor {
  public name!: string;
  public characterPlayed!: string;
  public isHandsome!: boolean;


};
export class AppComponent {
  
  title = 'application';
 actor = new Actor();
actor.name = 'Amrish Puri';
actor.characterPlayed = 'Mogambo';
actor.isHandsome = true; 

}


