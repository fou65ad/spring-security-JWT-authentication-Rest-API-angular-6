import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes ,RouterModule} from '@angular/router';
import { FormsModule} from '@angular/forms';
import { HttpClientModule,HttpClient, HttpHeaders } from '@angular/common/http'; 

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TasksComponent } from './tasks/tasks.component';
import { NewTaskComponent } from './new-task/new-task.component';
import { RegistrationComponent } from './registration/registration.component';
import { AthenticationService } from './service/authentication.service';


const  appRoutes : Routes = [
  {path:"login", component: LoginComponent},
  {path:"tasks", component: TasksComponent},
  {path:"new-task", component:NewTaskComponent},
  {path:"register", component:RegistrationComponent},
  {path:"", redirectTo:"login",pathMatch:"full"},

];


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TasksComponent,
    NewTaskComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(appRoutes),FormsModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
