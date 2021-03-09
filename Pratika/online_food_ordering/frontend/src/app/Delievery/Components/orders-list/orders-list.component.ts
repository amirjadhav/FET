import { Component, OnInit, Input } from '@angular/core';
import { OrdersService } from 'src/app/utility/services/orders/orders.service';
import { RestaurantService } from 'src/app/utility/services/restaurant/restaurant.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { OtpConfirmModalComponent } from '../otp-confirm-modal/otp-confirm-modal.component';
import { ViewDeliveryDetailsModalComponent } from '../view-delivery-details-modal/view-delivery-details-modal.component';
import { UserProfileService } from 'src/app/utility/services/user-profile/user-profile.service';
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-orders-list',
  templateUrl: './orders-list.component.html',
  styleUrls: ['./orders-list.component.scss']
})
export class OrdersListComponent implements OnInit {
  deliveryOrderList: any;
  acceptedOrderList: any;
  completedOrderList: any;
  delID: any;
  isUser:any;
  deliveryPerson: any;

  constructor(private _ordersService: OrdersService, private _restaurantService: RestaurantService, private _userService: UserProfileService, private modalService: NgbModal, public router: Router) {
    this.delID = sessionStorage.getItem("id");
    this.isUser = sessionStorage.getItem("isUser");
    if(this.delID!=null)
    {
      if(this.isUser==="false")
      {
        this.getOrderList();
        this.getActiveOrderDetails();
        this.getDeliveryPersonDetails();
        this.getDeliveredOrders();
      }
      else{
        this.router.navigate(['**']);
      }
    }
    else
    {
      this.router.navigate(['/deliveryLogin']);
    }
  }

  getDeliveryPersonDetails() {
    this._ordersService.getDeliveryPersonDetails(this.delID).subscribe((res) => {
      this.deliveryPerson = res;
    });
  }

  getOrderList() {
    //to display list of orders which havent been accepted to be delivered yet
    this._ordersService.getAllOrders("Ordered").subscribe((res) => {
      this.deliveryOrderList = res;
      for (let o of res) {
        this._restaurantService.getSpecificRestaurant("id", o.rid).subscribe((resto) => {
          o["restaurant"] = resto;
        });
      }
    });

  }

  getActiveOrderDetails() {
    //to display list of orders which havent been accepted to be delivered yet
    this._ordersService.getOrdersByDidStatus(this.delID, "Accepted").subscribe((res) => {
      this.acceptedOrderList = res;
      for (let o of res) {
        this._restaurantService.getSpecificRestaurant("id", o.rid).subscribe((resto) => {
          o["restaurant"] = resto;
        });
      }
    });
  }

  getDeliveredOrders() {
    //to display list of orders which havent been accepted to be delivered yet
    this._ordersService.getOrdersByDidStatus(this.delID, "Delivered").subscribe((res) => {
      this.completedOrderList = res;
    });
  }

  onAcceptOrder(order: any) {
    var user;
    var otp = Math.floor(Math.random() * 90000) + 10000;
    this._ordersService.updateDeliveryStatus(order.oid, "Accepted", this.delID, otp).subscribe();
    this._userService.getSpecificUser(order.uid).subscribe((res) => {
      user = res;
      this._ordersService.sendOtpMail(order, this.deliveryPerson, user.email, otp).subscribe((res)=>{
        if(res.success)
          location.reload();
      });
    });
    //add orderitems in otp mail
  }

  confirmOtp(order: any) {
    const modalRef = this.modalService.open(OtpConfirmModalComponent);
    modalRef.componentInstance.order = order;
  }

  viewDetails(order: any) {
    const modalRef = this.modalService.open(ViewDeliveryDetailsModalComponent);
    modalRef.componentInstance.order = order;
  }

  ngOnInit(): void {

  }

}     
