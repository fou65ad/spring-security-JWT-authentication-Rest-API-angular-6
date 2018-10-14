import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { AthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

    error ;
    mode :number=0;                
  constructor(public authService : AthenticationService,private router:Router) { }

  ngOnInit() {
  }

  onRegister(user) {

    this.authService.saveUser(user).subscribe(
      resp=>{
        console.log(resp);
        this.mode=2;
      },err=>{
              this.mode=1;
             this.error = err.error.message;
  })
 
   }

}
