import { Component, OnInit } from '@angular/core';
import {ProjectService} from './project.service';
import {ProjectDetailService} from '../project-detail/project-detail.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css'],
  providers:[ProjectService]
})
export class ProjectComponent implements OnInit {
  constructor(
    private projectService:ProjectService,
    private projectDetailService:ProjectDetailService
  ) { }
  projects=[];
  ngOnInit() {
    this.projectService.getProjects().subscribe(resProjectsData=>
    {return this.projects = resProjectsData});
  }
  get(id:number){
    this.projectDetailService.id_project=id;
  }
}
