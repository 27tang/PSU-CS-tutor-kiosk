app.directive('tutorViewListEntry', function(){
   return {
       restrict: 'E',
       scope: {
           entries: '='
       },
       templateUrl: 'views/listPageTutorView/tutorViewListEntry.html',
       controller: 'listPageController'
   };
});