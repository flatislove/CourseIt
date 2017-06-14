import { Injectable } from '@angular/core';
import {Http, Response, Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class NewsMainService {

private url: string="http://localhost:8080/news";
  constructor(private http:Http) {}
  getNews(){
    return this.http.get(this.url).map((response:Response) => {return response.json();});
  }
}
