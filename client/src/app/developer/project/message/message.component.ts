import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../project.service';
import {Message} from './message';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css'],
  providers:[ProjectService]
})
export class MessageComponent implements OnInit {
  messages:Message[];

  constructor(private projectService:ProjectService) { }

  ngOnInit() {
    this.projectService.getMessages();
  }
  getMessagesOfCurrentProject(){
    this.projectService.getMessages().then(message=>this.messages=message);
    //  messages=this.projectService.getMessages();
  }
}
