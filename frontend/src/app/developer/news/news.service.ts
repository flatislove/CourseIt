import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class NewsService {

  constructor(private http:Http) { }

  getNews(){
    return this.http.get('http://localhost:8080/news')
      .map((res:Response) => {
        console.log('res: ', res)
       return res.json()

      });
  }

}
