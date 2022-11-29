angular.module('app', []).controller('indexControllerProd', function ($scope, $http) {
    const contextPath = 'http://localhost:8180/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    }

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
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

    $scope.findProductByPriceBetween = function () {
        console.log($scope.findProduct);
        $http({
            url: contextPath + '/products/find_by_price',
            method: 'get',
            params: {
                minPrice: $scope.filterPrice.minPrice,
                maxPrice: $scope.filterPrice.maxPrice,
            }
        }).then(function (responce) {
            $scope.filterPrice.minPrice = 0;
            $scope.filterPrice.maxPrice = 30000;
            $scope.ProductList = responce.data;
        });
    }

    $scope.loadProducts();
});