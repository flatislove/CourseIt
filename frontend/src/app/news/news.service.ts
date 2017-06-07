import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Rx";
import "rxjs/Rx";

@Injectable()
export class NewsService {

  private news : string = "/news";

  constructor(private http: Http) { }

  newsGet() : Observable<string>{
    return this.http.get(this.news).map((resp : Response) => resp.text());
  }
}
