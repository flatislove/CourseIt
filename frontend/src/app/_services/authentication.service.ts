
import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {AuthConfigConsts, AuthHttp, AUTH_PROVIDERS} from 'angular2-jwt';
import 'rxjs/add/operator/map'
import {Router} from '@angular/router';
import {environment} from '../../environments/environment';

@Injectable()
export class AuthenticationService {
  constructor(private http: Http,private authHttp: AuthHttp, private router: Router) { }

  login(username: string, password: string) {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http
      .post(
        `${environment.serverUrl}auth/login`,
        JSON.stringify({username, password}),
        {headers}
      )
      .map(res => {
        return res.json();
      })
      .do(token => {
        localStorage.setItem(AuthConfigConsts.DEFAULT_TOKEN_NAME, token.token);
      });
  }

  logout() {
    localStorage.removeItem(AuthConfigConsts.DEFAULT_TOKEN_NAME);
    localStorage.removeItem('user');
    this.router.navigate(['/login'])
  }

  getMe() {
    return this.authHttp.get(`${environment.serverUrl}auth/me`).map(res => res.json());
  }
}



// import {Injectable} from '@angular/core';
// import {Http,Response} from '@angular/http';
// import {Observable} from 'rxjs/Observable';
// import 'rxjs/add/operator/map';
//
// @Injectable()
// export class AuthenticationService {
//   public token: string;
//
//   constructor(private http: Http) {
//     // set token if saved in local storage
//     var currentUser = JSON.parse(localStorage.getItem('currentUser'));
//     this.token = currentUser && currentUser.token;
//   }
//
//   login(username: string, password: string): Observable<boolean> {
//     return this.http.post('/api/authenticate', JSON.stringify({ username: username, password: password }))
//       .map((response: Response) => {
//         // login successful if there's a jwt token in the response
//         let token = response.json() && response.json().token;
//         if (token) {
//           // set token property
//           this.token = token;
//
//           // store username and jwt token in local storage to keep user logged in between page refreshes
//           localStorage.setItem('currentUser', JSON.stringify({ username: username, token: token }));
//
//           // return true to indicate successful login
//           return true;
//         } else {
//           // return false to indicate failed login
//           return false;
//         }
//       });
//   }
//
//   logout(): void {
//     // clear token remove user from local storage to log user out
//     this.token = null;
//     localStorage.removeItem('currentUser');
//   }
// }
