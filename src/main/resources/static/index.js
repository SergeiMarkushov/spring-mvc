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
        }).then(function (responce){
            $scope.ProductList = responce.data.content;
        });
    };


    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (responce) {
                $scope.loadProducts();
            });
    }
    $scope.createProduct = function () {
        console.log($scope.newProduct);
        $http.post(contextPath +'/products', $scope.newProduct)
            .then(function (responce){
                $scope.loadProducts();
            });
    }

    $scope.loadProducts();
});