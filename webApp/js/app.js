var app = angular.module('kioskApp', ['ui.router']);

app.config(function($httpProvider){
    //enable cross domain calls:
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
});

app.config(function($stateProvider, $urlRouterProvider){
    $urlRouterProvider.otherwise('/mainMenu');

    $stateProvider

        .state('mainMenu', {
            url: '/mainMenu',
            templateUrl: 'views/mainMenu.html',
            controller: 'mainMenuController'
        })

        .state('tutorLogin', {
            url: '/tutorLogin',
            templateUrl: 'views/tutorLogin.html',
            controller: 'tutorLoginController'
        })

        .state('listPage', {
            url: '/listPage',
            templateUrl: 'views/listPage.html',
            controller: 'listPageController'
        })

});
















