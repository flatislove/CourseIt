import {Component, HostBinding, OnDestroy, OnInit} from '@angular/core';
import {News, NewsService} from './news.service';
import {slideInDownAnimation} from '../../animations';
import 'rxjs/add/operator/switchMap';
import {Observable} from 'rxjs/Observable';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {ProjectService} from '../project/project.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css'],
  providers:[NewsService],
  animations: [slideInDownAnimation]
})
export class NewsComponent implements OnInit{
  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display') display = 'block';
  @HostBinding('style.position') position = 'absolute';

  newses: Observable<News[]>;
  private selectedId: number;

  constructor(private newsService: NewsService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.newses = this.route.params
      .switchMap((params: Params) => {
        this.selectedId = +params['id'];
        return this.newsService.getNewses();
      })
  }

  isSelected(news: News) {
    return news.id === this.selectedId;
  }

  onSelect(news: News) {
    this.router.navigate(['/news', news.id]);
  }

}
