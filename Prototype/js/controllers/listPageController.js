app.factory('idSaver', function($http) {

    var savedId = "";
    return {
        set: function(toSet) {
            savedId = toSet;
        },
        get: function() {
            return savedId;
        },
        clear: function() {
            console.log("SavedId Used to be: " +savedId+ ", now its nulled");
            savedId = "";
        }

    }
});


app.controller('listPageController', ['$state','$scope','$timeout', 'helpList', 'entities','idSaver',
    function($state, $scope, $timeout, helpList, entities, idSaver) {

        $scope.locations = [
            'Front',
            '88-01',
            '88-02',
            '88-03',
            '88-04',
            '88-05',
            '88-06',
            '88-07',
            '88-08',
            '88-09'
        ];


    $scope.tutorList = {
        X: 900996708,
        Brook: 333333333,
        Rohan: 222222222,
        MrMeeseeks: 111111111
    };
    $scope.launcher = {};
        console.log("launched it");


        $scope.launcher.tId = idSaver.get();
            idSaver.clear();

    $scope.checkIfTidIsTutor = function(){
            var isTutor = false;
            for(key in $scope.tutorList) {
                var tutor = $scope.tutorList[key];
                console.log(typeof(tutor));
                if ($scope.launcher.tId == tutor) {
                    console.log("ID entered belongs to a tutor.");
                    isTutor = true;
                }
            }
            return isTutor;
    };
    $scope.getTutorObject = function(tutorId) {
        entities.getTutor(tutorId).then(function(result){
            $scope.launcher.tutorObject = result.data;
        });
    };

    if($scope.checkIfTidIsTutor()){
        $scope.getTutorObject($scope.launcher.tId);
    }

    $scope.identifyLaunchState = function(){
        var isTutor = $scope.checkIfTidIsTutor();
        if(isTutor){
            idSaver.set($scope.launcher.tId);

            angular.element(document.querySelector('#goButton')).toggleClass('flashButton');
            angular.element(document.querySelectorAll('.listPageItems')).toggleClass('fadeOut');

            $timeout(function(){$state.go('listPageTutorView')}, 700);


        } else if($scope.checkIfStudentExists()) {
            $scope.getStudentObject($scope.launcher.tId);


            $state.go('.newEntryForm.selectCourse');
        } else {
        }
    };

    $scope.$watch('idForm.idInput.$valid', function(newVal, oldVal){

        console.log(newVal);
        console.log(oldVal);

        if(newVal) {
            $scope.identifyLaunchState();
        }
    });

    $scope.checkIfStudentIsOnList = function(){

    };
    $scope.checkIfStudentExists = function (){
      //do checking later
        return true;
    };

    $scope.generateSampleEntries = function(){
        for(i = 0; i < 5; ++i) {
            $scope.postListEntry(999999990+i, "CS100", 0, i);
        }
    };


    $scope.reloadPage = function(){
        $state.go($state.$current, null, { reload: true });
        console.log("I'm reeloaded!")
    };

    $scope.deleteListEntry = function(entryId){
      console.log("DELETING ENTRY: "+ entryId);
        helpList.deleteHelpListEntry(entryId);
    };

    $scope.getStudentObject = function(studentId) {
        entities.getStudent(studentId).then(function(result){
            $scope.launcher.studentObject = result.data;
        });
    };

    $scope.updateHelpList = function() {
        helpList.getHelpList().then(function (result) {
            $scope.helpListEntries = result.data; //.data.listEntry;


            console.log($scope.helpListEntries);

            var length = Object.keys($scope.helpListEntries).length;

            $scope.aSyncLoop(length, function (index) {
                    $scope.aSyncGetStudent(index, $scope.helpListEntries)
                },
                function () {
                    console.log("Async student to helpList load complete.");
                });

            $scope.aSyncLoop(length, function (index) {
                    $scope.aSyncGetTutor(index, $scope.helpListEntries)
                },
                function () {
                    console.log("Async tutors to helpList load complete.")

                })

        });

    };
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
                    func(index-1);
                    loop.next();
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
       // return loop;
    };

    //adds a student object to each help list entry based on the student id in the entry
    $scope.aSyncGetStudent = function(index, hlEntries){
        var tID = hlEntries[index].tuteeId;
        hlEntries[index].ind = index;

        entities.getStudent(tID).then(function(result){
            hlEntries[index].studentObject = result.data;
            hlEntries[index].studentName = result.data.name;
        });
    };

    //add's a tutor object to each help list entry based on the student id in the entry
    $scope.aSyncGetTutor = function(index, hlEntries){
        var tID = hlEntries[index].tutorId;

        if(tID == null){
            hlEntries[index].tutorObject = null;
        } else {
            entities.getTutor(tID).then(function(result){
                hlEntries[index].tutorObject = result.data;
            });
        }

    };

    $scope.postListEntry = function (tuteeId, courseNum, tutorId, location) {

        var date = new Date().toJSON();
        console.log(date);
        //var newDate = date.substr(0,23) + '-07:00';

        var text = '{"listEntry":{"course":"' + courseNum + '","date":"' + date + '","location":"' + location + '","tuteeId":'+ tuteeId +',"tutorId":' + tutorId + '}}';

        console.log(text);
        helpList.postHelpList(text).then(function(result){
            $scope.reloadPage();
        });
    };




    $scope.getSelectedTuteeId = function(index){
        var indices = angular.element(document.querySelectorAll('#listIndex'));
        $scope.launcher.entryId = parseInt(indices[index].innerHTML);
     //   console.log(typeof($scope.launcher.entryId));
       // console.log( $scope.helpListEntries[$scope.launcher.entryId]);
        angular.element(document.querySelectorAll('.listEntriesHL')).removeClass('trHighlighted');
        angular.element(document.querySelectorAll('.listEntry' + index))
            .toggleClass('trHighlighted');

        $timeout(function(){
            angular.element(document.querySelectorAll('.listEntry' + index)).removeClass('trHighlighted')
        }, 5000);
    };


        //TUTOR VIEW CONTROLS

        $scope.expandBox = function(index) {

            var indices = angular.element(document.querySelectorAll('#TlistIndex'));
            $scope.launcher.entryId = parseInt(indices[index].innerHTML);

            angular.element(document.querySelectorAll('.entryBorderBox')).removeClass('expandedBox');
            angular.element(document.querySelectorAll('.entryNumber' + index))
                .toggleClass('expandedBox');

            $timeout(function(){
                angular.element(document.querySelectorAll('.entryNumber' + index)).removeClass('expandedBox')
            }, 5000);
        };

        $scope.putTutor = function(tutorToPut, index){
            var entry = $scope.helpListEntries[$scope.launcher.entryId];
            entry.tutorId = tutorToPut;
            $scope.aSyncGetTutor($scope.launcher.entryId, $scope.helpListEntries);

            var text = '{"listEntry":{"course":"' + entry.course + '","date":"' + entry.date +  '","location":"'
                + entry.location + '","tuteeId":'+ entry.tuteeId +',"entryId":'
                + $scope.launcher.entryId +',"tutorId":' + entry.tutorId + '}}';
            console.log("********************");
            console.log(entry.tutorId);
            console.log(entry.date);
            helpList.putHelpListEntry(entry.tuteeId, text).then(function(result){
               // $scope.reloadPage();
            });

            if(tutorToPut != null){


                angular.element(document.querySelectorAll('.entryNumber' + index + ' #tutorAssigned'))
                    .removeClass('entryItemFadeIn');
                angular.element(document.querySelectorAll('.entryNumber' + index + ' #tutorAssigned'))
                    .toggleClass('entryItemFadeIn');
            }

        };

        $scope.removeTutor = function(index) {

            angular.element(document.querySelectorAll('.entryNumber' + index + ' #tutorAssigned'))
                .toggleClass('entryItemFadeOut');
            console.log("nulled it");

            $timeout(function(){

                $scope.putTutor(null, index);
                $timeout(function() {
                    angular.element(document.querySelectorAll('.entryNumber' + index + ' #tutorAssigned'))
                        .removeClass('entryItemFadeOut');
                }, 100);

            }, 1050)


        };


        $scope.deleteEntry = function(entryId, index){
            console.log("DELETING INDEX: " + index);

            var elem = angular.element(document.querySelectorAll('.entryNumber' + index))
                .toggleClass('boxFadeOut');

            $timeout(function(){

                var entry = $scope.helpListEntries[entryId];
                console.log($scope.helpListEntries);
                console.log("IDEE: " + entryId);
                helpList.deleteHelpListEntry(entry.tuteeId).then(function(result){


                    // $scope.reloadPage();

                });

                $scope.helpListEntries.splice($scope.launcher.entryId, 1);

                var i;
                for(i = 0; i < $scope.helpListEntries.length; i++){
                    $scope.helpListEntries[i].ind = i;
                }

            }, 900)


            //$timeout(function(){$scope.$apply(); console.log("APPLIED"); console.log($scope.helpListEntries);}, 2000);

        };



}]);