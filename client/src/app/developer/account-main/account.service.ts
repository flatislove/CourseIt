import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import {AuthenticationService} from '../../_services/authentication.service';
import {User} from './user';

@Injectable()
export class AccountService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private tokenKey:string='token';

  constructor(private http:Http, private authService:AuthenticationService) { }

  getCurrentUser(nickname: string): Promise<User> {
    //const url = `${this.heroesUrl}/${id}`;
    return this.http.get("http://localhost:8080/account")
      .toPromise()
      .then(response => response.json().data as User)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

   // getCurrentUser(){
   //   return this.http.get("http://localhost:8080/account",JSON.stringify(localStorage.getItem('current_nickname')).(data=>
  //     data.json().data as User)
  //     .catch());
  // }
}
