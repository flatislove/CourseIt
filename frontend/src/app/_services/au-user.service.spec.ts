/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { AuUserService } from './au-user.service';

describe('AuUserService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuUserService]
    });
  });

  it('should ...', inject([AuUserService], (service: AuUserService) => {
    expect(service).toBeTruthy();
  }));
});
