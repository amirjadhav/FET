import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CartService } from 'src/app/utility/services/cart/cart.service';
import { ModalDeleteCartComponent } from '../modal-delete-cart/modal-delete-cart.component';

@Component({
  selector: 'app-quantity-scroll',
  templateUrl: './quantity-scroll.component.html',
  styleUrls: ['./quantity-scroll.component.scss']
})
export class QuantityScrollComponent implements OnInit {

  @Input() quantity: number = 0;
  @Input() allIds: number[] = [];
  @Input() disable: boolean = false;

  @Output()
  value = new EventEmitter<number>();

  is_disabled: boolean = false;

  constructor(private _cartService: CartService, private _modalService: NgbModal) {}

  ngOnInit(): void {
    this.is_disabled = this.checkUser();
    
  }

  checkUser(): boolean {
    if (sessionStorage.getItem('id') !== null) {
      return (sessionStorage.getItem("isUser") === "true") ? false : true
    }
    return true;
  }

  addQuantity(): void {
    let postCall = (id: any[]) => {
      this.quantity += 1;
      this._cartService.createItems({
        "oid": id[0],
        "mid": id[1],
        "quantity":1}
      ).subscribe();
     let count:any= (sessionStorage.getItem('cartitems'));
     if(count===null||count==="0"){
      sessionStorage.setItem('cartitems',"1");
     }
     else{
      count=parseInt(count)+1;
      sessionStorage.setItem('cartitems',count);
     }

    }

    let noPostCall = () => {
      this.quantity = 0;
    }

    let updateId = (id: any[]) => {
      this._cartService.updateCart(id[0], {
        rid: id[2]
      }).subscribe();
    }

    if (this.quantity === 0) {
      const userId: any = sessionStorage.getItem("id");
      if (userId !== null) {
        this._cartService.getCartItems(userId).subscribe(res => {
          if (res.items.length !== 0){
            if (res.items[0].menu.restid === this.allIds[2]) {
              postCall(this.allIds);
            } else {
              this.openModal(userId, this.allIds);
            }
          } else {
            updateId(this.allIds);
            postCall(this.allIds);
          }
        });
      } else {
        noPostCall();
      }
    } else {
      this.quantity += 1;
      this.changeQuantity(this.quantity)
    }
  }

  minusQuantity(): void {
    this.quantity -= 1;
    if (this.quantity > 0) {
     this.changeQuantity(this.quantity)
    } else {
        this._cartService.deleteItem(this.allIds[0],this.allIds[1]).subscribe(() => {
        this.value.emit(this.quantity);
      });
 
      let count:any= (sessionStorage.getItem('cartitems'));
      count=parseInt(count)-1;
      sessionStorage.setItem('cartitems',count);

     }
  }

  //Change in quantity
  changeQuantity(newQuantity: number): void {
    this._cartService.updateQuantity(this.allIds[0],this.allIds[1], newQuantity).subscribe(() => {
     this.value.emit(this.quantity);
    });
  }

  openModal(userId: number, allIds: number[]) {
    const modalRef = this._modalService.open(ModalDeleteCartComponent);
    modalRef.componentInstance.onDelete.subscribe(() => {
      this._cartService.getCartItems(userId).subscribe(res => {
        var oid = res.oid;
        this._cartService.updateCart(allIds[0], {
          rid: allIds[2]
        }).subscribe(() => {
          this._cartService.createItems({
            "oid": allIds[0],
            "mid": allIds[1],
            "quantity":1}
          ).subscribe(() => {
            this.quantity += 1;
            res.items.forEach((element: any) => {
              this._cartService.deleteItem(oid, element.mid).subscribe();
            });
          });
          sessionStorage.setItem('cartitems',"1");
           
        });
      });
    })
  }
}
