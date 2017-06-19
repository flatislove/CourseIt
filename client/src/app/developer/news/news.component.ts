import {Component, OnInit} from '@angular/core';
import {NewsService} from './news.service';
import 'rxjs/add/operator/switchMap';
import {Router} from '@angular/router';
import {News} from './news';
import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css'],
  providers: [NewsService],
})
export class NewsComponent implements OnInit {

  newse: News[];
  selectNews: News;

  constructor(private newsService: NewsService,
              private router: Router) {
  }

  getNewse(): void {
    this.newsService
      .getNewse()
      .then(newse => this.newse = newse);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) {
      return;
    }
    this.newsService.create(name)
      .then(news => {
        this.newse.push(news);
        this.selectNews = null;
      });
  }

  delete(news: News): void {
    this.newsService
      .delete(news.id)
      .then(() => {
        this.newse = this.newse.filter(h => h !== news);
        if (this.selectNews === news) {
          this.selectNews = null;
        }
      });
  }

  ngOnInit(): void {
    this.getNewse();
  }

  onSelect(news: News): void {
    this.selectNews = news;
  }

  gotoDetail(): void {
    this.router.navigate(['/news', this.selectNews.id]);
  }
}
