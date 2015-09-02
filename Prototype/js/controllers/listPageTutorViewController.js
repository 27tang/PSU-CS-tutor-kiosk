/**
 * Created by x on 9/1/15.
 */
app.controller('listPageTutorViewController', ['$scope', 'idSaver', 'entities', function($scope, idSaver, entities){
    $scope.tId = idSaver.get();

    entities.getTutor($scope.tId).then(function(result) {
        $scope.tutorObject = result.data;
    });

}]);