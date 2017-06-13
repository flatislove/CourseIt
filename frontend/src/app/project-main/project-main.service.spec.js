"use strict";
/* tslint:disable:no-unused-variable */
Object.defineProperty(exports, "__esModule", { value: true });
var testing_1 = require("@angular/core/testing");
var project_main_service_1 = require("./project-main.service");
describe('ProjectMainService', function () {
    beforeEach(function () {
        testing_1.TestBed.configureTestingModule({
            providers: [project_main_service_1.ProjectMainService]
        });
    });
    it('should ...', testing_1.inject([project_main_service_1.ProjectMainService], function (service) {
        expect(service).toBeTruthy();
    }));
});
