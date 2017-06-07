import { Component, OnInit } from '@angular/core';
import {LoginService} from "./login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers:[LoginService]
})
export class LoginComponent implements OnInit {

  private testString:string;

  constructor(private service: LoginService) {
  }

  ngOnInit() {
    this.service.loginGet().subscribe(testString => this.testString=testString);
  }

}
