import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-modal-delete-cart',
  templateUrl: './modal-delete-cart.component.html',
  styleUrls: ['./modal-delete-cart.component.scss']
})
export class ModalDeleteCartComponent implements OnInit {

  @Output() onDelete = new EventEmitter<boolean>();

  constructor(public activeModal: NgbActiveModal) { }

  ngOnInit(): void {
  }

  deleteAll(): void {
    this.onDelete.emit(true);
    this.activeModal.close('Close click');
  }
}
