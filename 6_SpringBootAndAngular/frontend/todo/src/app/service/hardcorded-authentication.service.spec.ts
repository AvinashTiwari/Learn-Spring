import { TestBed } from '@angular/core/testing';

import { HardcordedAuthenticationService } from './hardcorded-authentication.service';

describe('HardcordedAuthenticationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HardcordedAuthenticationService = TestBed.get(HardcordedAuthenticationService);
    expect(service).toBeTruthy();
  });
});
