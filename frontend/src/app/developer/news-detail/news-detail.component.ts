import {Component, HostBinding, OnInit} from '@angular/core';
import {slideInDownAnimation} from '../../animations';
import {News, NewsService} from '../news/news.service';
import {ActivatedRoute, Router, Params} from '@angular/router';
@Component({
  selector: 'news-detail',
  templateUrl: './news-detail.component.html',
  styleUrls: ['./news-detail.component.css'],
  animations: [slideInDownAnimation]
})
export class NewsDetailComponent implements OnInit {
  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display') display = 'block';
  @HostBinding('style.position') position = 'absolute';

  news:News;

  constructor(private route: ActivatedRoute,
              private newsService: NewsService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.route.params
      .switchMap((params:Params)=>this.newsService.getNews(+params['id']))
      .subscribe((news:News)=>this.news=news);
  }

  gotoProjects(){
    let projectId = this.news ? this.news.id:null;
    this.router.navigate(['/news',{id:projectId,foo:'foo'}]);
  }

}
