var validationApp = angular.module('editIssue', []);

validationApp.controller('validationController', function($scope, $window) {
    $scope.issue = $window.issue;
});