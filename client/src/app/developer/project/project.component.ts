import {Component, OnInit} from '@angular/core';
import {Project, ProjectService} from './project.service';
import {ActivatedRoute, Params, Router} from '@angular/router';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css'],
  providers: [ProjectService],
})
export class ProjectComponent implements OnInit {


  projects: any;
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
    this.projectService.addInfoToStorage(project.id);
    this.router.navigate(['/projects', project.id]);
  }
}
