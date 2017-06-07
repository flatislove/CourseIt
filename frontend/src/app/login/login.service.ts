import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class LoginService {

  private loginString:string = "/login"

  constructor(private http:Http) {
  }
  loginGet():Observable<string>{
    return this.http.get(this.loginString).map((resp: Response) => resp.text());
  }

}
