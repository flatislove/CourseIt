import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';

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

  constructor(private http: Http) {
  }


  private url: string = 'http://localhost:8080/projects';

  getProjects() {
    return projectMockPromise;
    //return this.http.get(this.url).map((response:Response) => {return response.json();});
  }

  getProject(id: number | string) {
    return projectMockPromise.then(projects => projects.find(project => project.id === +id));
    // return this.getProjects()
    //   .subscribe(projects=>projects.find(project=>project.id===id));
  }
}
