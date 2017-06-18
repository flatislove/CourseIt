import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../project.service';
import {Message} from './message';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
  messages:Message[];

  constructor(private projectService:ProjectService) { }

  ngOnInit() {

    this.projectService.getMessages(2);

  }

}
