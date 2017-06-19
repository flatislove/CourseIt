import {Component} from '@angular/core';
import {MarkdownService} from './markdown.service';
import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'markdown',
  templateUrl: './markdown.component.html',
  styleUrls: ['./markdown.component.css'],
  providers: [MarkdownService]
})
export class MarkdownComponent {
  convertedText: string;

  constructor(private md: MarkdownService) {
  }
  
  updateOutput(mdText: string) {
    this.convertedText = this.md.convert(mdText)

  }

}
