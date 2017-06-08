import { Injectable } from '@angular/core';
import {News} from "./news";

@Injectable()
export class NewsService {
  getNews(): Promise<News[]> {
    return Promise.resolve(NewsList);
  }

  // See the "Take it slow" appendix
  getNewsSlowly(): Promise<News[]> {
    return new Promise(resolve => {
      // Simulate server latency with 2 second delay
      setTimeout(() => resolve(this.getNews()), 2000);
    });
  }
}
