import {Component, HostBinding, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Project, ProjectService} from '../project.service';
import 'rxjs/add/operator/switchMap';
import {slideInDownAnimation} from '../../../animations';
import {environment} from '../../../../environments/environment';


@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css'],
  animations: [slideInDownAnimation]
})

export class ProjectDetailComponent implements OnInit {
  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display') display = 'block';
  @HostBinding('style.position') position = 'absolute';

  project: Project;

  constructor(private route: ActivatedRoute,
              private projectService: ProjectService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.route.params
      .switchMap((params:Params)=>this.projectService.getProject(+params['id']))
      .subscribe((project:Project)=>this.project=project);
    //`${environment.serverUrl}`
  }

  gotoNewses(){
    let projectId = this.project ? this.project.id:null;
    this.router.navigate(['/projects']);
  }
}
