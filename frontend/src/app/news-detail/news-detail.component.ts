import {Component, OnInit } from '@angular/core';
import {NewsMainService} from '../news-main/news-main.service';
@Component({
  selector: 'news-detail',
  template:'<h2>News Detail</h2><ul *ngFor="let news of newsList"><li>{{news.description}}. {{news.id}} - {{news.text}}</li></ul>',
  //templateUrl: './news-detail.component.html',
  styleUrls: ['./news-detail.component.css']
})
export class NewsDetailComponent implements OnInit {

  newsList=[];

  constructor(private newsService:NewsMainService) { }

  ngOnInit() {
    this.newsService.getNews()
      .subscribe(resNewsData=>this.newsList=resNewsData);
  }

}
