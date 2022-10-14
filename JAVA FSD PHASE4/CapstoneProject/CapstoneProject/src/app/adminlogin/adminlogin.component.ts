import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Router } from '@angular/router';


@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
  registerForm!: FormGroup;

  
  submitted:boolean=false;

  email:string="";
  pass:string="";
  constructor(private builder:FormBuilder,private router:Router) { }

  
  ngOnInit(): void {

    this.registerForm= this.builder.group(
      {
        email:["",[Validators.required,Validators.email]],
        password:["",[Validators.required,Validators.minLength(8)]]
      }
    );
  }

  
  OnSubmit(){
    
    this.submitted=true;
    this.email=this.registerForm.get('email')?.value;
    this.pass=this.registerForm.get('password')?.value;
    if(this.email=="ab12@gmail.com" && this.pass=="12345678")
      this.router.navigateByUrl('/admin');
    else
      alert("Wrong Credentials");
  }

  
  get f(){
    return this.registerForm.controls;
  }





}
