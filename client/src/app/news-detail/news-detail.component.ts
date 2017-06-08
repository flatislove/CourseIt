import { Component, Input } from '@angular/core';
import { News } from '../news';

@Component({
  selector: 'news-detail',
  template: `
    <div *ngIf="news">
      <h2>{{news.description}} details!</h2>
      <div>
        <label>id: </label>{{news.id}}
      </div>
      <div>
        <label>desc: </label>
        <input [(ngModel)]="news.name" placeholder="description"/>
      </div>
    </div>
  `
})
export class HeroDetailComponent {
  @Input() news: News;
}
