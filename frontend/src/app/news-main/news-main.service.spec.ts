/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { NewsMainService } from './news-main.service';

describe('NewsMainService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NewsMainService]
    });
  });

  it('should ...', inject([NewsMainService], (service: NewsMainService) => {
    expect(service).toBeTruthy();
  }));
});
