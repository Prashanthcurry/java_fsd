import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DataService } from '../data.service';
import { EmployeeModel } from './persondetails.model';

@Component({
  selector: 'app-crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.css']
})
export class CrudComponent implements OnInit {

  employeeModelObj:EmployeeModel=new EmployeeModel();

  formValue!:FormGroup;
  employeeData!:any;
  showAdd!:boolean;
  showUpdate!:boolean;
  showUpdateTitle!:boolean
  showAddTitle!:boolean;

  constructor(private formBulider:FormBuilder,private service:DataService) { }

  addButtonClickFunction(){
    this.formValue.reset();
    this.showUpdate=false;
    this.showAdd=true;
    this.showUpdateTitle=false;
    this.showAddTitle=true;
  }

  ngOnInit(): void {
    this.formValue=this.formBulider.group({
      name:[''],
      address:[''],
      email:[''],
      dateofbirth:[''],
      gender:[''],
      phoneno:['']
    })
    this.getAllEmployee();
  }

  postEmployeeDetails(){
    this.employeeModelObj.id=this.formValue.value.id;
    this.employeeModelObj.name=this.formValue.value.name;
    this.employeeModelObj.address=this.formValue.value.address;
    this.employeeModelObj.email=this.formValue.value.email;
    this.employeeModelObj.phoneno=this.formValue.value.phoneno;
    this.employeeModelObj.dateofbirth=this.formValue.value.dateofbirth;
    this.employeeModelObj.gender=this.formValue.value.gender;
   

    let cancel = document.getElementById("cancel");
    this.service.postData(this.employeeModelObj).subscribe(a=>{
      console.log(a);
      alert("Record Inserted Successfully");
      cancel?.click();this.formValue.reset();
      this.getAllEmployee();
    })
  }

  getAllEmployee(){
    this.service.getData().subscribe(a=>{
      this.employeeData=a;
    })

  }
  deleteEmployee(row:any){
    this.service.deleteData(row.id).subscribe(a=>{
      alert("Record Deleted Successfully");
      this.getAllEmployee();
    })
  }

  updateEmployee(row:any){
    this.showUpdate=true;
    this.showAdd=false;
    this.showUpdateTitle=true;
    this.showAddTitle=false;
    this.employeeModelObj.id=row.id;
    this.formValue.controls['name'].setValue(row.name);
    this.formValue.controls['address'].setValue(row.address);
    this.formValue.controls['email'].setValue(row.email);
    this.formValue.controls['phoneno'].setValue(row.phoneno);
    this.formValue.controls['dateofbirth'].setValue(row.dateofbirth);
    this.formValue.controls['gender'].setValue(row.gender);
    
    

  }

  updateEmployeeDetails(){
    this.employeeModelObj.name=this.formValue.value.name;
    this.employeeModelObj.address=this.formValue.value.address;
    this.employeeModelObj.email=this.formValue.value.email;
    this.employeeModelObj.phoneno=this.formValue.value.phoneno;
    this.employeeModelObj.dateofbirth=this.formValue.value.dateofbirth;
    this.employeeModelObj.gender=this.formValue.value.gender;
    
    this.service.updateData(this.employeeModelObj,this.employeeModelObj.id).subscribe(a=>{
      alert("Record Updated Successfully");
      let cancel=document.getElementById("cancel");
      cancel?.click();
      this.formValue.reset();
      this.getAllEmployee();
    })
  }

  getEmployeeById(row:any){
    this.service.getDataById(row.id).subscribe(a=>{
      this.employeeData=a;
    })

  }

}


