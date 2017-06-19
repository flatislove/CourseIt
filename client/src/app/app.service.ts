import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class AppService {

  constructor(private router: Router, private http: Http) {
  }

  appToAccount() {
    this.router.navigate(['/account']);
  }

  appToNews() {
    this.router.navigate(['/news']);
  }

  appToProject() {
    this.router.navigate(['/project']);
  }

  appToHome() {
    this.router.navigate(['/api/users']);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}
