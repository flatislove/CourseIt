import {Component, HostBinding} from '@angular/core';
import { Router } from '@angular/router';
import {UserService} from '../_services/user.service';
import {AlertService} from '../_services/alert.service';
import {slideInDownAnimation} from '../animations';


@Component({
  moduleId: module.id,
  templateUrl: 'register.component.html',
  animations: [slideInDownAnimation]
})

export class RegisterComponent {
  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display') display = 'block';
  @HostBinding('style.position') position = 'absolute';
  model: any = {};
  loading = false;

  constructor(
    private router: Router,
    private userService: UserService,
    private alertService: AlertService) { }

  register() {
    this.loading = true;
    this.userService.create(this.model)
      .subscribe(
        data => {
          this.alertService.success('Registration successful', true);
          this.router.navigate(['/login']);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        });
  }
}
