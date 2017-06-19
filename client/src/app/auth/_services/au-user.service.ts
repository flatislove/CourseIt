import {Injectable} from '@angular/core';
import {environment} from '../../../environments/environment';
import {AuthHttp} from 'angular2-jwt/angular2-jwt';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class AuUserService {

  constructor(private authHttp: AuthHttp) {
  }

  findAll() {
    return this.authHttp.get(`${environment.serverUrl}/users`).map(res => res.json());
  }

  findOne(id: number) {
    return this.authHttp.get(`${environment.serverUrl}/users/${id}`).map(res => res.json());
  }

}
