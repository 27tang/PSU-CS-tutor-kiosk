

var app = angular.module('kioskApp', ['ngAnimate', 'ui.router']);


app.config(function($httpProvider){
    //enable cross domain calls:
    $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
});

app.config(function($stateProvider, $urlRouterProvider){
    $urlRouterProvider.otherwise('/mainMenu');

    $stateProvider


        .state('testImgPlace', {
            url: '/testImgPlace',
            templateUrl: 'views/testImgPlace.html',
            controller: 'testImgPlaceController'
        })

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

        .state('listPageTutorView', {
            url: '/listPageTutorView',
            templateUrl: 'views/listPageTutorView.html',
            controller: 'listPageController'
        })

        //nested view of listpage - multi-step form for creating a new help list entry
            .state('listPage.newEntryForm',{

                url: '/newListEntryForm',
                templateUrl: 'views/newListEntryForm/newEntryForm.html'
            })

                    .state('listPage.newEntryForm.selectCourse',{
                        url: '/selectCourse',
                        templateUrl: 'views/newListEntryForm/selectCourse.html'

                    })
                    .state('listPage.newEntryForm.selectLocation',{
                        url: '/selectLocation',
                        templateUrl: 'views/newListEntryForm/selectLocation.html'

                    })
                    .state('listPage.newEntryForm.confirm',{
                        url: '/confirm',
                        templateUrl: 'views/newListEntryForm/confirm.html'

                    })
            });
















