import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Router } from '@angular/router';



@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  employee = new Employee();
  constructor(private _router : Router) {
    this.employee.fullName = localStorage.getItem("fullName");
  }
  moveToHomePage() {
    this._router.navigate(['']);
  }
  ngOnInit(): void {
  }

}