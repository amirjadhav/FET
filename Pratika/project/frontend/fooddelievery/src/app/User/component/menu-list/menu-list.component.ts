import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.scss']
})
export class MenuListComponent implements OnInit {

  itemList: any = [
    {id: 1, quantity: 0},
    {id: 2, quantity: 0}
  ];

  constructor() { }

  ngOnInit(): void {
  }

  quantity: number = 7;
  getQuantity(id: number, event: number) {
    this.itemList[id-1].quantity = event;
  }

}
