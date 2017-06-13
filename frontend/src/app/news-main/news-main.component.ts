import {Component, OnInit} from '@angular/core';
import {NewsMainService} from './news-main.service';
import {Routes} from '@angular/router';
@Component({
  selector:'news-main',
  template:'<h3>News</h3><ul *ngFor="let news of newsList"><li>{{news.description}}</li></ul>',
})
export class NewsMainComponent implements OnInit{
  newsList=[];
  constructor(private newsService:NewsMainService){}
  ngOnInit(){
    this.newsService.getNews()
      .subscribe(resNewsData=>this.newsList=resNewsData);
  }
}
