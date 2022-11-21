angular.module('app', []).controller('showFormControllerProd', function ($scope, $http) {
    const contextPath = 'http://localhost:8180/app/show_form';

    $scope.loadForm = function () {
        $http.get(contextPath);
    }

    $scope.loadForm();
});