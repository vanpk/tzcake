import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserComponent } from './user/user.component';
import { AuthenticationGuard } from './guard/authentication.guard';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { HomeComponent } from './home/home.component';
import { CakeComponent } from './components/cake/cake.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'forgotpassword', component: ForgotpasswordComponent},
  { path: 'user/management', component: UserComponent, canActivate: [AuthenticationGuard] },
  { path: 'home', component: HomeComponent},
  { path: 'contactmanager', loadChildren: () => import('./components/contactmanager/contactmanager.module').then(m => m.ContactmanagerModule) },
  { path: '', loadChildren: () => import('./components/contactmanager/contactmanager.module').then(m => m.ContactmanagerModule) },
  { path: 'cake', component: CakeComponent},
  { path: '', redirectTo: '/home'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
