app.controller('listPageController', ['$state','$scope', 'helpList', 'entities', '$http', function($state, $scope, helpList, entities) {


    $scope.newEntry = {};



    $scope.reloadPage = function(){
        $state.go($state.$current, null, { reload: true });
        console.log("I'm reeloaded!")
    };

    $scope.entryToDelete = 0;
    $scope.deleteListEntry = function(entryId){
      console.log("DELETING ENTRY: "+ entryId);
        helpList.deleteHelpListEntry(entryId);
    };


    $scope.getStudentName = function(studentId) {
        entities.getStudent(studentId).then(function(result){
            $scope.newEntry.studentObject = result.data.student;
        });
    };

    $scope.updateHelpList = function() {

        helpList.getHelpList().then(function (result) {
            $scope.helpListEntries = result.data.listEntry;
            var length = Object.keys($scope.helpListEntries).length;

            $scope.aSyncLoop(length, function (loop, index) {
                    $scope.aSyncGetStudent(index, $scope.helpListEntries, function (result) {
                        loop.next();
                    })
                },
                function () {
                    console.log("Async student to helpList load complete.");
                });

            $scope.aSyncLoop(length, function (loop, index) {
                    $scope.aSyncGetTutor(index, $scope.helpListEntries, function (result) {
                        loop.next();
                    })
                },
                function () {
                    console.log("Async tutors to helpList load complete.")

                })
        });
    }
    $scope.updateHelpList(); //initial call to load helpList

    //Asynchronous Loop used to populate listEntries' student and tutor objs
    $scope.aSyncLoop = function (iterations, func, callback) {
        var index = 0;
        var done = false;
        var loop = {
            next: function () {
                if (done) {
                    return;
                }
                if (index < iterations) {
                    index++;
                    func(loop, index-1);
                } else {
                    done = true;
                    callback();
                }
            },
            //show iteration
            iteration: function () {
                return index - 1;
            },
            //exit loop
            break: function () {
                done = true;
                callback();
            }
        };
        loop.next();
        return loop;
    };

    //adds a student object to each help list entry based on the student id in the entry
    $scope.aSyncGetStudent = function(index, hlEntries, callback){
        var tID = hlEntries[index].tuteeId;

        entities.getStudent(tID).then(function(result){
            hlEntries[index].studentObject = result.data.student;
        });
        callback();
    };

    //add's a tutor object to each help list entry based on the student id in the entry
    $scope.aSyncGetTutor = function(index, hlEntries, callback){
        var tID = hlEntries[index].tutorId;

        entities.getTutor(index, tID).then(function(result){
            hlEntries[index].tutorObject = result.data.tutor;
        });
        callback();
    };

    $scope.postListEntry = function (tuteeId, courseNum, tutorId, location) {

        var date = new Date().toJSON();
        var newDate = date.substr(0,23) + '-07:00';
        var text = '{"listEntry":{"course":"' + courseNum + '","date":"' + newDate + '","location":"' + location + '","tuteeId":'+ tuteeId +',"tutorId":' + tutorId + '}}';

        console.log(text);
        helpList.postHelpList(text).then(function(result){
            $scope.reloadPage();
        });



    };



    /* //non-working student getter - results in scramblage
     helpList.getHelpList().then(function (result) {
     $scope.helpListEntries = result.data.listEntry;
     var inc = 0;

     console.log($scope.helpListEntries);

     for (var key in $scope.helpListEntries) {
     if ($scope.helpListEntries.hasOwnProperty(key)) {
     var tID = $scope.helpListEntries[key].tuteeId;
     console.log("wtfman");


     student.getTheStudent(tID).then(function (result) {
     console.log($scope.helpListEntries);
     console.log($scope.helpListEntries.entryId);
     // console.log($scope.helpListEntries[$scope.helpListEntries.entryId]);
     $scope.helpListEntries[inc].studentObject = result.data.student;
     inc++;
     });
     }
     }
     });
     */

}]);