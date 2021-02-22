import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-quantity-scroll',
  templateUrl: './quantity-scroll.component.html',
  styleUrls: ['./quantity-scroll.component.scss']
})
export class QuantityScrollComponent implements OnInit {

  @Input()
  quantity: number = 0;

  @Output()
  value = new EventEmitter<number>()
  constructor() { }

  ngOnInit(): void {
  }

  addQuantity() {
    this.quantity += 1;
    this.value.emit(this.quantity);
  }

  minusQuantity() {
    if (this.quantity > 0) {
      this.quantity -= 1;
      this.value.emit(this.quantity);
    }
  }

}
