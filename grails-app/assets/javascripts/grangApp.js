var grangApp = angular.module('grangApp', []);
grangApp.controller('MainCtrl', ['$scope',
    function($scope) {
        $scope.helloText = 'Hello Grang Demo!';
    }
])