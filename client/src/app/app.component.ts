import { Component, OnInit } from '@angular/core';

import { News } from './news';
import { NewsService } from './news.service';

@Component({
  selector: 'app',
  template: `
    <h1>{{title}}</h1>
    <h2>My Heroes</h2>
    <ul class="news">
      <li *ngFor="let news of newss"
        [class.selected]="news === selectedNews"
        (click)="onSelect(news)">
        <span class="badge">{{news.id}}</span> {{news.description}}
      </li>
    </ul>
    <news-detail [news]="selectedNews"></news-detail>
  `,
  styles: [`
    .selected {
      background-color: #CFD8DC !important;
      color: white;
    }
    .news {
      margin: 0 0 2em 0;
      list-style-type: none;
      padding: 0;
      width: 15em;
    }
    .news li {
      cursor: pointer;
      position: relative;
      left: 0;
      background-color: #EEE;
      margin: .5em;
      padding: .3em 0;
      height: 1.6em;
      border-radius: 4px;
    }
    .news li.selected:hover {
      background-color: #BBD8DC !important;
      color: white;
    }
    .news li:hover {
      color: #607D8B;
      background-color: #DDD;
      left: .1em;
    }
    .news .text {
      position: relative;
      top: -3px;
    }
    .news .badge {
      display: inline-block;
      font-size: small;
      color: white;
      padding: 0.8em 0.7em 0 0.7em;
      background-color: #607D8B;
      line-height: 1em;
      position: relative;
      left: -1px;
      top: -4px;
      height: 1.8em;
      margin-right: .8em;
      border-radius: 4px 0 0 4px;
    }
  `],
  providers: [NewsService]
})
export class AppComponent implements OnInit {
  title = 'Tour of Heroes';
  news: News[];
  selectedNews: News;

  constructor(private newsService: NewsService) { }

  getNews(): void {
    this.newsService.getNews().then(news => this.news = news);
  }

  ngOnInit(): void {
    this.getNews();
  }

  onSelect(news: News): void {
    this.selectedNews = news;
  }
}
