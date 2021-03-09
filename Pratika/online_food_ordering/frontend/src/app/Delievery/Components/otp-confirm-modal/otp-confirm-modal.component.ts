import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import { OrdersService } from 'src/app/utility/services/orders/orders.service';


@Component({
  selector: 'app-otp-confirm-modal',
  templateUrl: './otp-confirm-modal.component.html',
  styleUrls: ['./otp-confirm-modal.component.scss']
})
export class OtpConfirmModalComponent implements OnInit {

  constructor(public modal: NgbActiveModal, private _ordersService: OrdersService) { }

  order:any;
  otp:String ='';
  digit1:any;
  digit2:any;
  digit3:any;
  digit4:any;
  digit5:any;
  @Output() passEntry: EventEmitter<any> = new EventEmitter();
  
  verifyOtp()
  {
    this.otp = this.digit1+this.digit2+this.digit3+this.digit4+this.digit5
    this.passEntry.emit(this.otp)
    if(this.otp == this.order.otp)
    {
      console.log("matched")
      this._ordersService.updateDeliveryStatus(this.order.oid,"Delivered",this.order.delID,this.order.otp).subscribe();
      this.modal.close();
      location.reload();
    }
    else
    {
      alert("Incorrect OTP.");
    }
  }
  ngOnInit() {
  }

}