angular.module('app', []).controller('indexControllerProd', function ($scope, $http) {
    const contextPath = 'http://localhost:8180/app/api/v1';


    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                part_title: $scope.filter ? $scope.filter.part_title : null,
                min_cost: $scope.filter ? $scope.filter.min_cost : null,
                max_cost: $scope.filter ? $scope.filter.max_cost : null
            }
        }).then(function (response){
            $scope.ProductsPage = response.data;
        });
    };

    $scope.loadCart = function () {
        $http.get(contextPath + '/cart')
            .then(function (response) {
                $scope.CartList = response.data;
            });
    };

    $scope.deleteFromCart = function (productId) {
        $http.delete(contextPath +'/cart/remove/{productId}/product' + productId)
            .then(function (response) {
                $scope.CartList = response.data;
            });
    };

    $scope.addToCart = function (productId) {
        $http.get(contextPath + '/cart' + productId)
            .then(function (responce){
                alert("Added " + productId);
                $scope.CartList = responce.data;
            });
    };

    $scope.loadProducts();
    $scope.loadCart();
});