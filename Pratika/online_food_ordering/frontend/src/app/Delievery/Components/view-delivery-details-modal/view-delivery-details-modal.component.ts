import { Component, OnInit } from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-view-delivery-details-modal',
  templateUrl: './view-delivery-details-modal.component.html',
  styleUrls: ['./view-delivery-details-modal.component.scss']
})
export class ViewDeliveryDetailsModalComponent implements OnInit {

  order:any;
  restName:any;
  restAdd:any;

  constructor(public modal: NgbActiveModal) { }

  ngOnInit(): void {
  }

}
