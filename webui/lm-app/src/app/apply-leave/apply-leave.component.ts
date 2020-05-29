import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Leave } from '../leave';
import { LeaveService } from '../leave.service';
import { NgForm} from '@angular/forms';

@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css']
})
export class ApplyLeaveComponent implements OnInit {
  leave = new Leave();
  result : string;
  isValidFormSubmitted : boolean;
  constructor(private _leaveService : LeaveService, private _router : Router) {
    this.leave.empId = parseInt(localStorage.getItem("empId"));
    this.isValidFormSubmitted = false;
  }

  applyLeave(form : NgForm) {
    this.isValidFormSubmitted = false;
    if(form.invalid) {
      return;
    }
    this._leaveService.applyLeave(this.leave.empId, this.leave.startDate, this.leave.endDate,
      this.leave.leaveType, this.leave.leaveReason).subscribe(x => {
        this.result = x;
        
      })
      setTimeout(() => {
        this._router.navigate(['/Dashboard'])
        }
        ,1000);
  }
  moveToDashBoard() {
    this._router.navigate(['/Dashboard'])
  }
  ngOnInit(): void {
  }
}
