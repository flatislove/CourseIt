import {Component, OnInit} from '@angular/core';
import {ProjectDetailService} from './project-detail.service';

@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css']
})
export class ProjectDetailComponent implements OnInit {

  constructor(private projectDetailService: ProjectDetailService) { }
  project=null;
  ngOnInit() {
    this.projectDetailService.getProjectDetails(this.projectDetailService.id_project).subscribe(projectData=>
    {return this.project=projectData});
  }

}
