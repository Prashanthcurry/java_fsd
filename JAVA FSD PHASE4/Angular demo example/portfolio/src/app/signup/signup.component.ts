

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,Validators} from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  registerForm: FormGroup;
  submitted:boolean=false;
  constructor(private builder:FormBuilder,private router:Router) { }

  ngOnInit(): void {
    this.registerForm= this.builder.group(
      {
        firstName:["",Validators.required],
        lastName:["",Validators.required],
        email:["",[Validators.required,Validators.email]],
        password:["",[Validators.required,Validators.minLength(8)]]
      }
    );
  }
  OnSubmit(){
    this.submitted=true;
    if(this.registerForm.invalid)
      return;
    else
      alert("Form Submitted Successfully");
  }
  public onDisplay(){
    this.router.navigate(['./home']);
  }
  
  get f(){
    return this.registerForm.controls;
  }

}