import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import {publish} from 'rxjs/operator/publish';

export class News{
  constructor(public id:number,public date:Date,public description:string,
      public text:string,public role:string){}
}

let newses = [
  new News(11,new Date, 'Mr. Nice', 'Mr. Nice', 'Mr. Nice'),
  new News(12,new Date, 'Narco', 'Narco', 'Narco'),
  new News(13,new Date, 'Bombasto', 'Bombasto', 'Bombasto'),
  new News(14,new Date, 'Celeritas', 'Celeritas', 'Celeritas')
];
let newsMockPromise= Promise.resolve(newses);

@Injectable()
export class NewsService {

  constructor(private http:Http) { }

  getNewses(){
    return newsMockPromise;
    //return this.http.get(this.url).map((response:Response) => {return response.json();});
  }

  getNews(id: number | string) {
    return newsMockPromise.then(newses => newses.find(news => news.id === +id));
    // return this.getProjects()
    //   .subscribe(projects=>projects.find(project=>project.id===id));
  }

}
