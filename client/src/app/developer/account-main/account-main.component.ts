import {Component, OnInit} from '@angular/core';
import {AccountService} from './account.service';
import {User} from './user';
import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'app-account-main',
  templateUrl: './account-main.component.html',
  styleUrls: ['./account-main.component.css'],
  providers: [AccountService]
})
export class AccountMainComponent implements OnInit {
  user: User;

  constructor(private accountService: AccountService) {
  }

  ngOnInit() {
    return this.accountService.getCurrentUser(localStorage.getItem('current_nickname'));

  }

}
