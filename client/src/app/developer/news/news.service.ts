import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {News} from './news';

@Injectable()
export class NewsService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private newsUrl = 'http://localhost:8080/news';

  constructor(private http: Http) {
  }

  getNewse() {
    return this.http.get(this.newsUrl)
      .toPromise()
      .then(response => response.json().data as News[])
      .catch(this.handleError);
  }

  getNews(id: number): Promise<News> {
    const url = `${this.newsUrl}/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json().data as News)
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.newsUrl}/${id}`;
    return this.http.delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  create(name: string): Promise<News> {
    return this.http
      .post(this.newsUrl, JSON.stringify({name: name}), {headers: this.headers})
      .toPromise()
      .then(res => res.json().data as News)
      .catch(this.handleError);
  }

  update(news: News): Promise<News> {
    const url = `${this.newsUrl}/${news.id}`;
    return this.http
      .put(url, JSON.stringify(news), {headers: this.headers})
      .toPromise()
      .then(() => news)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
