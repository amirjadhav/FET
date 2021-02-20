import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeliveryProfileComponent } from './Delievery/Components/delivery-profile/delivery-profile.component';
import { DeliverySignupComponent } from './Shared/component/delivery-signup/delivery-signup.component';
import { UserSignupComponent } from './Shared/component/user-signup/user-signup.component';
import { CartComponent } from './User/component/cart/cart.component';
import { MenuListComponent } from './User/component/menu-list/menu-list.component';
import { RestaurantListComponent } from './User/component/restaurant-list/restaurant-list.component';
import { UserProfileComponent } from './User/component/user-profile/user-profile.component';

const routes: Routes = [
  {path: '',component: RestaurantListComponent},
  {path: 'restaurant/:name',component: MenuListComponent},
  {path: 'cart',component: CartComponent},
  {path: 'delivery',component: DeliveryProfileComponent},
  {path: 'userProfile',component: UserProfileComponent},
  {path: 'addUser',component: UserSignupComponent},
  {path: 'addDelivery',component: DeliverySignupComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
