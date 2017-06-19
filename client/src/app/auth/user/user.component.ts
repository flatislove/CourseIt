import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../../_services/authentication.service';
import {AuUserService} from '../../_services/au-user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users = [];
  errorMessage: string;

  constructor(private userService: AuUserService, private authService: AuthenticationService) { }

  ngOnInit() {
    this.userService.findAll().subscribe(
      users => this.users = users,
      error => this.errorMessage = error.json().message
    );
  }

  logout() {
    this.authService.logout();
  }


}
