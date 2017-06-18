import {Injectable} from '@angular/core';
import {Http,Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import {Message} from './message/message';

export class Project {
  constructor(public id: number, public name: string, public text: string, public description: string) {
  }
}

let projjjj = [
  new Project(11, 'Mr. Nice', 'Mr. Nice', 'Mr. Nice'),
  new Project(12, 'Narco', 'Narco', 'Narco'),
  new Project(13, 'Bombasto', 'Bombasto', 'Bombasto'),
  new Project(14, 'Celeritas', 'Celeritas', 'Celeritas')
];

let projectMockPromise = Promise.resolve(projjjj);

@Injectable()
export class ProjectService {
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) {
  }

  private urlMessage:string = 'http://localhost:8080/message';
  private url: string = 'http://localhost:8080/projects';
  private urlTag:string='${environment.serverUrl}/tag';
  private urlDeveloper:string='${environment.serverUrl}/tag';

  getProjects() {
    return this.http.get(this.url)
      .map(data=>{
        data.json();
        return data.json();
      })
    //return projectMockPromise;
    //return this.http.get(this.url).map((response:Response) => {return response.json();});
  }

  getProject(id: number | string) {
    return projectMockPromise.then(projects => projects.find(project => project.id === +id));
    // return this.getProjects()
    //   .subscribe(projects=>projects.find(project=>project.id===id));
  }

  getMessages(id_project:number){
    this.http.get(this.urlMessage,id_project).map(data=>{
      data.json();
      return data.json();
    })
  }

  getProjectTag(){}

  getProjectDeveloper(){}

  getProjectManager(){}

  addMessage(text: string, project_id:number, user_id:number ): Promise<Message> {
    return this.http
      .post(this.urlMessage, JSON.stringify({text: text, project_id:project_id,user_id:user_id}), {headers: this.headers})
      .toPromise()
      .then(res => res.json().data as Message)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
