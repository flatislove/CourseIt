import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class NewsDetailService {
  private url: string = '${environment.serverUrl}/news/';

  constructor(private http: Http) {
  }
}
