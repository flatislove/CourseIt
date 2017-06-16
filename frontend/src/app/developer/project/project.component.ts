import {Component, HostBinding, OnInit} from '@angular/core';
import {Project, ProjectService} from './project.service';
import {ActivatedRoute, Params, Router} from '@angular/router';
import 'rxjs/add/operator/switchMap';
import {Observable} from 'rxjs/Observable';
import {slideInDownAnimation} from '../../animations';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css'],
  providers: [ProjectService],
  animations: [slideInDownAnimation]
})
export class ProjectComponent implements OnInit {
  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display') display = 'block';
  @HostBinding('style.position') position = 'absolute';
  //projects=[];
  projects: Observable<Project[]>;
  private selectedId: number;

  constructor(private projectService: ProjectService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.projects = this.route.params
      .switchMap((params: Params) => {
        this.selectedId = +params['id'];
        return this.projectService.getProjects();
      })
  }

  isSelected(project: Project) {
    return project.id === this.selectedId;
  }

  onSelect(project: Project) {
    this.router.navigate(['/projects', project.id]);
  }
}
