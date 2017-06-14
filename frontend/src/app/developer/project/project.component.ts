import { Component, OnInit } from '@angular/core';
import {ProjectService} from './project.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css'],
  providers:[ProjectService]
})
export class ProjectComponent implements OnInit {
  constructor(private projectService:ProjectService) { }
  projects=[];
  ngOnInit() {
    this.projectService.getProjects().subscribe(resProjectsData=> {return this.projects = resProjectsData});
  }
}
