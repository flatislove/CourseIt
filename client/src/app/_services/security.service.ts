import {Injectable} from '@angular/core';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class SecurityService {

  constructor() {
  }

  isLoggedIn() {
    return !!localStorage.getItem('token') && !!localStorage.getItem('user');
  }

}
