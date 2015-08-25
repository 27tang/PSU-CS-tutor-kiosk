app.controller('mainMenuController', function($scope, $timeout, $state){
    $scope.buttonInfos = [
        {
            state: 'mainMenu',
            name: 'Account Manager'
        },
        {
            state: 'tutorLogin',
            name: 'Tutor Login'
        },
        {
            state: 'listPage',
            name: 'Help List'
        }
    ];

    function goState(buttonToFlash){
        var index = parseInt(buttonToFlash);
        console.log(buttonToFlash);
        $state.go($scope.buttonInfos[index].state);
        console.log("REMOVING CLASS?");
        angular.element(document.querySelector('#button-'+ buttonToFlash)).removeClass('flashButton');
        angular.element(document.querySelectorAll('.kbutton')).removeClass('fadeOut');

    }

    $scope.buttonGo = function(buttonToFlash){

        angular.element(document.querySelector('#button-'+ buttonToFlash)).toggleClass('flashButton');
        angular.element(document.querySelectorAll('.kbutton')).toggleClass('fadeOut');


        $timeout( function(){goState(buttonToFlash)}, 700);
    }

});