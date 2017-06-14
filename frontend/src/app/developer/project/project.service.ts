///<reference path="../../../../node_modules/rxjs/add/operator/map.d.ts"/>
import { Injectable } from '@angular/core';
import {Http,Response} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ProjectService {

  constructor(private http:Http) {
  }

  private url:string="http://localhost:8080/projects";

  getProjects(){
    return this.http.get(this.url).map((response:Response) => {return response.json();});
  }
}
