import {Injectable, Input} from '@angular/core';
import {Http,Response} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ProjectDetailService {
  constructor( private http:Http) {}
  private url:string="http://localhost:8080/project/";
  @Input() id_project:number;
  getProjectDetails(id:number){
    return this.http.get(this.url+id).map((response:Response) => {return response.json();});
  }

}
