import {Component, HostBinding, OnInit} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {slideInDownAnimation} from '../../animations';

@Component({
  moduleId: module.id,
  templateUrl: 'login.component.html',
  animations: [slideInDownAnimation]
})

export class LoginComponent implements OnInit {
  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display') display = 'block';
  @HostBinding('style.position') position = 'absolute';
  model: any = {};
  loading = false;
  returnUrl: string;
  errorMessage: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
    // reset login status
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  login() {
    this.loading = true;
    this.errorMessage = null;
    this.authenticationService.login(this.model.username, this.model.password)
      .flatMap(data => {
        return this.authenticationService.getMe();
      })
      .subscribe(
        data => {
          localStorage.setItem('user', JSON.stringify(data));
          this.router.navigate([this.returnUrl]);
        },
        error => {
          this.loading = false;
          this.errorMessage = error.json().message;
        }
      );
  }
}
