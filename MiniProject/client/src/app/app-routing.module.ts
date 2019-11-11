import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdduserComponent } from './adduser/adduser.component';
import { ResultComponent } from './result/result.component';

const routes: Routes = [
  { path: '', component: ResultComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: AdduserComponent },
  { path: 'result', component: ResultComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
