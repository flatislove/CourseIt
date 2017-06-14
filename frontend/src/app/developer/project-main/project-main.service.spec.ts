/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ProjectMainService } from './project-main.service';

describe('ProjectMainService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProjectMainService]
    });
  });

  it('should ...', inject([ProjectMainService], (service: ProjectMainService) => {
    expect(service).toBeTruthy();
  }));
});
