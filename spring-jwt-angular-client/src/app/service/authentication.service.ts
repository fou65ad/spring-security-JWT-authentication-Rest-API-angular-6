import { Injectable } from '@angular/core';
import { HttpClientModule,HttpClient, HttpHeaders } from '@angular/common/http'; 
import { Observable, of } from 'rxjs';
import {JwtHelperService} from '@auth0/angular-jwt';

// const httpOptions = {
//   headers: new HttpHeaders({ 'Content-Type': 'application/json' })
// };


@Injectable({
  providedIn: 'root'
})
export class AthenticationService {

  private host:string ="http://localhost:8080";
  private jwtToken:string=null;
  private roles:Array<any>=[];
  constructor (private http:HttpClient) {}

  login(user) {
    return this.http.post(this.host +"/login",user,{observe : 'response'});
  }
  saveUser(user) {
    return this.http.post(this.host +"/register",user);
  }

  loadToken() {
    this.jwtToken = localStorage.getItem('token');
    if (this.jwtToken) {
     let jwtHelper = new JwtHelperService();
    this.roles=jwtHelper.decodeToken(this.jwtToken).roles;
      return true;
    }

    return false;
    
  }

  saveToken(jwt:string){
    this.jwtToken=jwt;
    localStorage.setItem('token',jwt);
    let jwtHelper = new JwtHelperService();
    this.roles=jwtHelper.decodeToken(this.jwtToken).roles;
  }

  getTasks() {
    if(this.jwtToken==null) this.loadToken();
    return this.http.get(this.host+"/tasks",{headers : new HttpHeaders({ 'Authorization':this.jwtToken }) });
  }

  logout() {
    this.jwtToken=null;
    localStorage.removeItem('token');
  }

  isAdmin(){
    for (let r of this.roles) {
      if (r.authority=='ADMIN') return true;
      }

      return false;
  }

  saveTask(task) {
    let headers = new HttpHeaders();
    headers.append('authorization',this.jwtToken);
    return this.http.post(this.host+"/tasks",task,{headers : new HttpHeaders({ 'Authorization':this.jwtToken }) });
  }


}