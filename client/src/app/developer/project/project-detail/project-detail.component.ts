import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Project, ProjectService} from '../project.service';
import 'rxjs/add/operator/switchMap';
import {environment} from '../../../../environments/environment';
import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css'],
  providers: [ProjectService],
})

export class ProjectDetailComponent implements OnInit {

  project: Project;
  private url: string = `${environment.serverUrl}`;

  constructor(private route: ActivatedRoute,
              private projectService: ProjectService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.projectService.getProject(+params['id']))
      .subscribe(project => this.project = project);
    localStorage.setItem('current_project', JSON.stringify(this.project.id));
  }

  gotoProject() {
    let projectId = this.project ? this.project.id : null;

    this.router.navigate(['/projects']);
  }

  goToMessages(id_project: number) {
    this.router.navigate(['/projects/' + id_project + '/message']);
  }

  goToMarkdown(id_project: number) {
    this.router.navigate(['/projects/' + id_project + '/markdown']);
  }

  goToFiles(id_project: number) {
    this.router.navigate(['/projects/' + id_project + '/files']);
  }
}
