import { Component, OnInit } from '@angular/core';
import {MarkdownService} from './markdown.service';

@Component({
  selector: 'markdown',
  templateUrl: './markdown.component.html',
  styleUrls: ['./markdown.component.css'],
  providers:[MarkdownService]
})
export class MarkdownComponent {//implements OnInit {
  convertedText:string;

  constructor(private md:MarkdownService) { }


  // ngOnInit() {
  // }
  updateOutput(mdText:string){
    this.convertedText=this.md.convert(mdText)

  }

}
