import { Component } from '@angular/core';
import {NewsMainService} from './news-main/news-main.service';
import {Router} from '@angular/router';

@Component({
  selector: 'my-app',
 // template: '<h1>Random News</h1><news-main></news-main><news-detail></news-detail>',
  template: '<h1>Course Application</h1>' +
  '<nav>' +
      '<a routerLink="/news" routerLinkActive="active">News</a>' +
      '<a routerLink="/projects" routerLinkActive="active">Projects</a>' +
  '</nav>' +
  '<router-outlet></router-outlet>',
  styleUrls: ['./app.component.css'],
  providers:[NewsMainService]
})
export class AppComponent {
  constructor(private router:Router){}

  public toHome(){
    this.router.navigate(['/news'],{skipLocationChange:false});
  }

  public toLogin(){
    this.router.navigate(['/login'],{skipLocationChange:false})
  }
}
