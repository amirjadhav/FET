import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './landing/landing.component';
import { AdminhomeComponent } from './admin/adminhome/adminhome.component';
import { UserhomeComponent } from './user/userhome/userhome.component';
import { ErrorComponent } from './error/error.component';

const routes: Routes = [
  {
    path: '', component: LandingComponent
  },
  {
    path: 'admin', component: AdminhomeComponent
  },
  {
    path: 'user', component: UserhomeComponent
  },
  {
    path: '**', component: ErrorComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
