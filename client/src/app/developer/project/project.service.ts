import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';
import 'rxjs/add/operator/map';
import {Message} from './message/message';
import {Router} from '@angular/router';
import 'rxjs/add/operator/toPromise';

export class Project {
  constructor(public id: number, public name: string, public text: string, public description: string) {
  }
}

@Injectable()
export class ProjectService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private tokenKey: string = 'token';

  constructor(private http: Http, private router: Router) {
  }

  private urlMessage: string = 'http://localhost:8080/projects/' + `${localStorage.getItem('current_project')}` + '/message';
  // private urlMessage:string = `${environment.serverUrl}+projects/+${localStorage.getItem("current_project")}+/message`;
  //private url: string = `${environment.serverUrl}`;
  private url: string = 'http://localhost:8080/projects';
  private urlTag: string = 'http://localhost:8080/tag';
  private urlDeveloper: string = '${environment.serverUrl}/tag';

  getProjects(): Promise<Project[]> {
    this.router.navigate(['/projects']);
    return this.http.get('http://localhost:8080/projects')
      .toPromise().then(response => response.json().data as Project[])
      .catch(this.handleError);


  }

  getProject(id: number): Promise<Project> {
    const url = `${this.url}/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json().data as Project)
      .catch(this.handleError);
  }

  getMessages(): Promise<Message[]> {
    return this.http.get('http://localhost:8080/projects' + parseInt(localStorage.getItem('current_project')) + '/message').toPromise().then(data =>
      data.json().data as Message[])
      .catch(this.handleError);
  }

  addInfoToStorage(idProject: number) {
    localStorage.setItem(this.tokenKey, JSON.stringify(idProject));
  }

  getProjectTag() {
  }

  getProjectDeveloper() {
  }

  getProjectManager() {
  }

  addMessage(text: string, project_id: number, user_id: number): Promise<Message> {
    return this.http
      .post(this.urlMessage, JSON.stringify({text: text, project_id: project_id, user_id: user_id}), {headers: this.headers})
      .toPromise()
      .then(res => res.json().data as Message)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
