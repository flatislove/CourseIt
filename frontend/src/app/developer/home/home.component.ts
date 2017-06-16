import {Component, HostBinding, OnInit} from '@angular/core';
import {User} from '../../_models/user';
import {UserService} from '../../_services/user.service';
import {slideInDownAnimation} from '../../animations';


@Component({
  moduleId: module.id,
  templateUrl: 'home.component.html',
  animations: [slideInDownAnimation]
})

export class HomeComponent implements OnInit {
  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display') display = 'block';
  @HostBinding('style.position') position = 'absolute';
  currentUser: User;
  users: User[] = [];

  constructor(private userService: UserService) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.loadAllUsers();
  }

  deleteUser(id: number) {
    this.userService.delete(id).subscribe(() => {
      this.loadAllUsers()
    });
  }

  private loadAllUsers() {
    this.userService.getAll().subscribe(users => {
      this.users = users;
    });
  }
}
