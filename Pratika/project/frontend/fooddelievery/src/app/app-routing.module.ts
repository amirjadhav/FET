import { ThankyouComponent } from './components/thankyou/thankyou.component';
import { CartComponent } from './components/cart/cart.component';
import { MenuComponent } from './components/menu/menu.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{
  path:'',component:MenuComponent
},
{
  path:'cart',component:CartComponent
},
{
  path:'thankyou',component:ThankyouComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
