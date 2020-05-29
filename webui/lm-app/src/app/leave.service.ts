import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import { Leave } from './leave';
import { Observable } from 'rxjs';
import { map } from 'rxjs-compat/operator/map';

@Injectable({
  providedIn: 'root'
})
export class LeaveService {

  constructor(private _http : Http) { }

  showLeaveHistory(empId : number, startDate : string, endDate : string) : Observable<Leave[]> {
    return this._http.get("http://localhost:8080/SNAPSHOT/api/leaves/leaveHistory/"+empId + "/" +startDate + "/" + endDate).
    map((res : Response) => res.json()); 
  }
  applyLeave(empId : number, startDate : string, endDate : string, leaveType : string,
    leaveReason : string) : Observable<string> {
    return this._http.post("http://localhost:8080/SNAPSHOT/api/leaves/applyLeaveForEmployee/" + empId + "/"
     + startDate + "/" + endDate + "/" + leaveType + "/" + leaveReason + "/" + "abc"  ,null).
    map((res : Response) => res.text());
  }
  pending(empId :number) : Observable<Leave[]> {
    return this._http.get("http://localhost:8080/SNAPSHOT/api/leaves/pendingLeaves/"+empId+"/P").
    map((res : Response) => res.json());
  }
  approvedeny(leaveId : number, mgrId:number , option:number) : Observable<string> {
    return this._http.post("http://localhost:8080/SNAPSHOT/api/leaves/approveDeny/" + leaveId + "/" + mgrId + "/" + option+"/",null).
    map((res : Response) => res.text());
   }
   searchLeave(leaveId : number) : Observable<Leave> {
    return this._http.get("http://localhost:8080/SNAPSHOT/api/leaves/leaveId/"+ leaveId).
    map((res : Response) => res.json());
}
showLeave() : Observable<Leave[]> {
  return this._http.get("http://localhost:8080/SNAPSHOT/api/leaves/").
  map((res : Response) => res.json());
}
}
