import { NgModule } from '@angular/core';
import { BrowserModule} from '@angular/platform-browser';
import{HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { UserserviceService } from './userservice.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    AdminComponent,
    AdminloginComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [UserserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
