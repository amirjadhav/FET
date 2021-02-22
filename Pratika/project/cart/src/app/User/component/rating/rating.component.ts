import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.scss']
})
export class RatingComponent implements OnInit{

  @Input()
  selected = 0;

  @Input()
  readonly = true;

  @Input()
  size = 1.5;

  @Output()
  rating = new EventEmitter<number>()

  constructor() { }

  ngOnInit(): void {
  }

  getRatings(ratings: number): void {
    this.rating.emit(ratings);
  }
}
