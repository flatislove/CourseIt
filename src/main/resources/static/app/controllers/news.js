angular.module('JWTDemoApp')
// Creating the Angular Controller
    .controller('NewsController', function($http, $scope, $rootScope, AuthService) {
        $scope.news = function () {
            $http.get('/news').success(function (res) {
                $scope.userForm.$setPristine();
            }).error(function (error) {
                $scope.message = error.message;
            });
        };
    })

