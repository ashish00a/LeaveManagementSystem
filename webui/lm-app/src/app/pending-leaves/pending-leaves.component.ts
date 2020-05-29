import { Component, OnInit } from '@angular/core';
import { LeaveService } from '../leave.service';
import {Observable} from 'rxjs'
import {Employee} from '../employee';
import {Leave} from  '../leave';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-pending-leaves',
  templateUrl: './pending-leaves.component.html',
  styleUrls: ['./pending-leaves.component.css']
})
export class PendingLeavesComponent implements OnInit {
  empId:number;
  leaveFound:Observable<Leave[]>;
  employees:Observable<Employee[]>;

  constructor(private _leaveService :LeaveService, private _employeeService :EmployeeService, private _router : Router) {
    this.empId=parseInt(localStorage.getItem("empId"));
    this.leaveFound= this._leaveService.pending(this.empId);
    this.employees=this._employeeService.showEmployee();
   }
   setClickrow(leaveId,empId,mgrId){
     localStorage.setItem("aplid",leaveId);
     localStorage.setItem("apenId",empId);
     localStorage.setItem("mh",mgrId);
     this._router.navigate(['/ApproveDeny'])
   }
   

  ngOnInit(): void {
  }

}