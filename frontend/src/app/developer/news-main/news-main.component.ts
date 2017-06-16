import {Component, HostBinding, OnInit} from '@angular/core';
import {NewsMainService} from './news-main.service';
import {slideInDownAnimation} from '../../animations';
@Component({
  selector:'news-main',
 templateUrl:'./news-main.component.html',
  styleUrls: ['./news-main.component.css'],
  animations: [slideInDownAnimation]
})
export class NewsMainComponent implements OnInit{
  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display') display = 'block';
  @HostBinding('style.position') position = 'absolute';
  newsList=[];
  constructor(private newsService:NewsMainService){}
  ngOnInit(){
    this.newsService.getNews().subscribe(resNewsData=> {return this.newsList = resNewsData});
  }
  redirectToNewsDetail(){
   // this.router.navigate(['']);
  }
}
