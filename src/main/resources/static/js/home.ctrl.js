angular.module('xanbitApp').controller('home', function($scope, $http) {
  $http.get('/info/').success(function(data) {
    $scope.info = data;
    $scope.launchdate = new Date(data.launchdate).toUTCString();
  })
});