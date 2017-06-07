import { Component, OnInit } from '@angular/core';
import {NewsService} from "./news.service";

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css'],
  providers: [NewsService]
})
export class NewsComponent implements OnInit {

  private testString:string;
  constructor(private service: NewsService) { }

  ngOnInit() {
    this.service.newsGet().subscribe(testString => this.testString=testString);
  }

}
