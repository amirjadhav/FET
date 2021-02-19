import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './User/component/cart/cart.component';
import { RestaurantListComponent } from './User/component/restaurant-list/restaurant-list.component';

const routes: Routes = [{

  path:'',component:RestaurantListComponent
},
  {path:'cart',component:CartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
