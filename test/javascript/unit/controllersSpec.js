'use strict';
describe('grangTest', function() {
    beforeEach(module('grangApp'));
    var scope, mainCtrl;
    beforeEach(inject(function($compile, $rootScope) {
        scope = $rootScope.$new();
    }));
    describe('grangMainCtrl', function() {
        beforeEach(inject(function($controller) {
            mainCtrl = $controller("MainCtrl", {
                $scope: scope
            });
        }));
        it("should set hello text", function() {
            var helloText = 'Hello Grang Demo!';
            expect(scope.helloText).toEqual(helloText);
        });
    })
});