import {Injectable} from '@angular/core';
import {Http,Response} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ProjectDetailService {
  constructor( private http:Http) {}
  private url:string="http://localhost:8080/project/";

  getProjectDetails(id:number){
    return this.http.get(this
        .url+2).map((response:Response) => {return response.json();});
  }



}
