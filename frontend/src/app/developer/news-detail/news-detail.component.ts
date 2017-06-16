import {Component, HostBinding, OnInit} from '@angular/core';
import {NewsMainService} from '../news-main/news-main.service';
import {slideInDownAnimation} from '../../animations';
@Component({
  selector: 'news-detail',
  //template:'',
  templateUrl: './news-detail.component.html',
  styleUrls: ['./news-detail.component.css'],
  animations: [slideInDownAnimation]
})
export class NewsDetailComponent implements OnInit {
  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display') display = 'block';
  @HostBinding('style.position') position = 'absolute';

  newsList=[];

  constructor(private newsService:NewsMainService) { }

  ngOnInit() {
    this.newsService.getNews()
      .subscribe(resNewsData=>this.newsList=resNewsData);
  }

}
