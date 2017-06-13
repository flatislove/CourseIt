import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()

export class NewsMainService {

private url: string="http://localhost:8080/app/news";
  constructor(private http:Http) {}
  getNews(){
    return this.http.get(this.url)
      .map((response:Response) => response.json())
  }
}
