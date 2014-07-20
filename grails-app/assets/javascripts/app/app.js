'use strict';

/* App Module */

var phonecatApp = angular.module('phonecatApp', [
    'ngRoute',
    'phonecatAnimations',

    'phonecatControllers',
    'phonecatFilters',
    'phonecatServices'
]);

phonecatApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
        when('/phones', {
            templateUrl: 'partials/phone-list.html',
            controller: 'PhoneListCtrl'
        }).
        when('/phones/:phoneId', {
            templateUrl: 'partials/phone-detail.html',
            controller: 'PhoneDetailCtrl'
        }).
        when('/books', {
            templateUrl: 'partials/book-list.html',
            controller: 'BookListCtrl'
        }).
        when('/newBook', {
            templateUrl: 'partials/newBook.html'
        }).
        when('/books/:bookId', {
            templateUrl: 'partials/book-detail.html',
            controller: 'BookDetailCtrl'
        }).
        when('/editBook/:bookId', {
            templateUrl: 'partials/editBook.html',
            controller: 'BookDetailCtrl'
        }).
        otherwise({
            redirectTo: '/phones'
        });
    }
]);