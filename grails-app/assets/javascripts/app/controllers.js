'use strict';

/* Controllers */

var phonecatControllers = angular.module('phonecatControllers', []);

phonecatControllers.controller('PhoneListCtrl', ['$scope', 'Phone',
    function($scope, Phone) {
        $scope.phones = Phone.query();
        $scope.orderProp = 'age';
    }
]);

phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams', 'Phone',
    function($scope, $routeParams, Phone) {
        $scope.phone = Phone.get({
            phoneId: $routeParams.phoneId
        }, function(phone) {
            $scope.mainImageUrl = phone.images[0];
        });

        $scope.setImage = function(imageUrl) {
            $scope.mainImageUrl = imageUrl;
        }
    }
]);

phonecatControllers.controller('BookListCtrl', ['$scope', 'Book',
    function($scope, Book) {
        $scope.books = Book.query();
        $scope.orderProp = 'title';
    }

]);

phonecatControllers.controller('BookDetailCtrl', ['$scope', '$http', '$routeParams', 'Book',
    function($scope, $http, $routeParams, Book) {
        $scope.book = Book.get({
            bookId: $routeParams.bookId
        });

        $scope.delBook = function() {
            console.log('delBook');
        }
    }
]);