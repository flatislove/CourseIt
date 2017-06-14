import {Component, OnDestroy, OnInit} from '@angular/core';
import {NewsMainService} from '../news-main/news-main.service';
import {NewsService} from './news.service';

interface NewsJson{
  description:string;
  text:string;
}

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css'],
  providers:[NewsService]
})
export class NewsComponent implements OnInit,OnDestroy {

  private jsonResponse:string;
  private newses: Array<NewsJson>;
  private subscription;
  constructor(private newsService:NewsService) { }

  ngOnInit() {
    this.subscription=this.newsService.getNews()
      .subscribe(
        (data)=>{
          this.jsonResponse=JSON.stringify(data);
          this.newses=data;
          console.log('jsonResponse: ', this.jsonResponse)
          console.log('newses: ', this.newses)
        },
        (err)=>console.log(err),
        ()=>console.log('compltete')
      );
  }
  ngOnDestroy(){
    this.subscription.unsubscribe();
  }
}
