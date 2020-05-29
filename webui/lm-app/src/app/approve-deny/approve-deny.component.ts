import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Leave} from '../leave';
import {Employee} from '../employee';
import {LeaveService} from '../leave.service';
import {EmployeeService} from '../employee.service';
import { Observable } from 'rxjs';
import { getLocaleExtraDayPeriodRules } from '@angular/common';
import { NgForm } from '@angular/forms';



@Component({
  selector: 'app-approve-deny',
  templateUrl: './approve-deny.component.html',
  styleUrls: ['./approve-deny.component.css']
})

export class ApproveDenyComponent implements OnInit {
  leave=new Leave();
  approvedeny = new Leave();
  employee= new Employee();
  leaveId:number;
  option:number;
  mgrId:number;
  empId:number;
  leaveType : string;
  result:string;
  employeeFound : Observable<Employee>;
  emps:Observable<Employee[]>;
  leavs:Observable<Leave[]>;
  managerFound : Observable<Employee[]>;
  leaveFound:Observable<Leave[]>;
  leaveFound1:Observable<Leave>;
  isValidFormSubmitted : boolean;


    constructor(private _empService : EmployeeService, private _leaveService : LeaveService, private _erouter : Router) {
      this.leaveId=parseInt(localStorage.getItem("aplid"));
      this.leave.leaveId = parseInt(localStorage.getItem("aplid"));
      this.mgrId = parseInt(localStorage.getItem("mh"));
  
      this.empId = parseInt(localStorage.getItem("apenId"));
      this.employeeFound = this._empService.searchEmployee(this.empId);
      this.leaveFound= this._leaveService.pending(this.empId);
      this.leaveFound1 = this._leaveService.searchLeave(this.leave.leaveId);
    
     }

   approveDeny() {
   
      let ltype : number;
      ltype = parseInt(this.leaveType);
      this._leaveService.approvedeny(this.leaveId,this.mgrId,ltype).subscribe(x=> { 
       this.result=x;
      })
      {
        setTimeout(() => {
          this._erouter.navigate(['/Dashboard'])}
          , 2000);
      }
    }
    
  ngOnInit(): void {
  }

}