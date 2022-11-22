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

    $scope.productInfo = function (productId) {
        $http.get(contextPath + '/product_info' + productId)
            .then(function (responce) {
            $scope.loadProducts();
        });
    }
    // $scope.changeCount = function (productId, delta) {
    //     $http({
    //         url: contextPath + '/products/change_count/',
    //         method: 'GET',
    //         params: {
    //             productId: productId,
    //             delta: delta
    //         }
    //     }).then(function (responce) {
    //         $scope.loadProducts();
    //     });
    // }
    $scope.showForm = function () {
        $http.get(contextPath + "/products/show_form/");
    }
    $scope.loadProducts();
});