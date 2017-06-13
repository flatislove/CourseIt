import {Injectable} from '@angular/core';
import {Http, Headers, Response, RequestOptions} from '@angular/http';
import {AuthenticationService} from './authentication.service';
import {Observable} from 'rxjs/Observable';
import {User} from '../_models/user';

@Injectable()
export class UserService{
  constructor(
    private http:Http,
    private authenticationService:AuthenticationService){}
    getUsers():Observable<User[]>{
      let headers = new Headers({'Authorization':'Bearer'+this.authenticationService.token});
      let options = new RequestOptions({headers:headers});
      return this.http.get('/api/users',options)
        .map((response:Response)=>response.json());
    }
}



