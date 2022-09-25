import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { UserClass } from '../UserClass';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private service:DataService) { }
 
  users:UserClass[];
  ngOnInit(): void {
    this.service.getAllUsers().subscribe(result=>this.users=result);
  }

}