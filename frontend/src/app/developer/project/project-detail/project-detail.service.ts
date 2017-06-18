import {Injectable} from '@angular/core';
import {Http,Response} from '@angular/http';
import 'rxjs/add/operator/map';
import { environment } from 'environments/environment';

@Injectable()
export class ProjectDetailService {
  constructor( private http:Http) {}
  private url:string='http://localhost/project/';
}
