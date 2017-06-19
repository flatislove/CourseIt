import {Component, OnInit} from '@angular/core';
import {NewsService} from '../news/news.service';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {News} from '../news/news';
import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'news-detail',
  templateUrl: './news-detail.component.html',
  styleUrls: ['./news-detail.component.css'],

})
export class NewsDetailComponent implements OnInit {

  news: News;

  constructor(private route: ActivatedRoute,
              private newsService: NewsService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.newsService.getNews(+params['id']))
      .subscribe(news => this.news = news);
    localStorage.setItem('current_project', JSON.stringify(this.news.id));
  }

  gotoNews() {
    let newsId = this.news ? this.news.id : null;
    this.router.navigate(['/news', {id: newsId, foo: 'foo'}]);
  }

}
