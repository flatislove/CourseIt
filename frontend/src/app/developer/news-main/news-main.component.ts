import {Component, OnInit} from '@angular/core';
import {NewsMainService} from './news-main.service';
@Component({
  selector:'news-main',
 templateUrl:'./news-main.component.html',
  styleUrls: ['./news-main.component.css']
})
export class NewsMainComponent implements OnInit{
  newsList=[];
  constructor(private newsService:NewsMainService){}
  ngOnInit(){
    this.newsService.getNews().subscribe(resNewsData=> {return this.newsList = resNewsData});
  }
  redirectToNewsDetail(){
   // this.router.navigate(['']);
  }
}
