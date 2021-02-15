import { DeleteComponent } from './components/delete/delete.component';
import { ImageDetailsComponent } from './components/image-details/image-details.component';
import { MainComponent } from './components/main/main.component';
import { AddImageComponent } from './components/add-image/add-image.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormComponent } from './components/reactive-form/reactive-form.component';


const routes: Routes = [
  {path:'addImage',component:AddImageComponent},
  {path:'imageList',component:MainComponent},
  {path:'detailed/:id',component:ImageDetailsComponent},
  {path:'edit/:id',component:ReactiveFormComponent},
  {path:'delete/:id',component:DeleteComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
