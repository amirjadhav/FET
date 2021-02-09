import { MainComponent } from './components/main/main.component';
import { AddImageComponent } from './components/add-image/add-image.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  {path:'addImage',component:AddImageComponent},
  {path:'imageList',component:MainComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
