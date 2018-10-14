import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { AthenticationService } from '../service/authentication.service';


@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {
  task;
  mode;
  constructor(public authService : AthenticationService,private router:Router) { }

  ngOnInit() {
  }

  onSaveTask(task) {
    this.authService.saveTask(task)
    .subscribe(resp=>{
      this.task=resp;
     this.router.navigateByUrl("/tasks"); 

    },err=>{
      this.mode = 0;
    });


  }

}
