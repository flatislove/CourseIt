/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TagCloudService } from './tag-cloud.service';

describe('TagCloudService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TagCloudService]
    });
  });

  it('should ...', inject([TagCloudService], (service: TagCloudService) => {
    expect(service).toBeTruthy();
  }));
});
