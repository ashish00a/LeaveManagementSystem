import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Leave } from '../leave';
import { LeaveService } from '../leave.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-leave-show-all',
  templateUrl: './leave-show-all.component.html',
  styleUrls: ['./leave-show-all.component.css']
})
export class LeaveShowAllComponent implements OnInit {

 
  leavs:Observable<Leave[]>;

  constructor(private _leaveservice : LeaveService, private _router : Router) {
    this.leavs = this._leaveservice.showLeave();
   }

  ngOnInit(): void {
  }

}