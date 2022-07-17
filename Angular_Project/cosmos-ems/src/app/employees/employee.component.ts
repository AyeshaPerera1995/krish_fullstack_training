import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee.service';
//import data folder 
// import employees from './data/employees.json';
import { Employee } from './Employees.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'em-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {

  // create String as title and call it on emplyee html
  title:string = "Employee Management Solution"
  // create employee array list. Get data from import file
  // employees:Employee[] = employees;
  //create new variable for filetered employees
  // filteredEmployees:Employee[] = employees;

  employees!:Employee[];
  filteredEmployees!:Employee[];

  showIcon:boolean = false;

  message: string = '';
  substriber!: Subscription;

  private _designationFilter:string = "";

  // set designation value
  set designationFilter(value:string){
    console.log('setter fired');
    this._designationFilter = value;
    this.filterByDesgnation();
  }

  // get designation value 
  get designationFilter():string{
    return this._designationFilter;
  }


  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.substriber = this.employeeService.getEmployees().subscribe({
      next: data => {
        this.filteredEmployees = data;
        this.employees = this.filteredEmployees
      }
    })
  }

  ngOnDestroy() {
    this.substriber.unsubscribe();
  }

// show and hide avatar images 
  toggleIcon(){
    this.showIcon = !this.showIcon;
  }

  // filter data by designation
  filterByDesgnation(){
    this.filteredEmployees = this.employees.filter(employee => employee.designation.includes(this.designationFilter));
  }

  onMessageReceived(value:string){
    this.message = value;
  }


}
