app.controller('testImgPlaceController',function($scope, $timeout){


    function timeItOut() {
        console.log("TICK" + new Date());
    }

    $scope.blastTheImage = function() {
        console.log(new Date());
        $scope.firstFunc();
        $scope.toggleBackButton();
        angular.element(document.querySelector('.testImgBack')).removeClass('testImgBackFlash');
    };

    $scope.firstFunc = function() {
        angular.element(document.querySelector('.imgButt')).toggleClass('imgButtChange');
    };

    $scope.toggleBackButton = function() {
        angular.element(document.querySelector('.testImgBack')).toggleClass('testImgBackChange');
    };

    $scope.goBack = function() {
        angular.element(document.querySelector('.testImgBack')).toggleClass('testImgBackFlash');
        $timeout(function(){$scope.blastTheImage()}, 300);

    };

});