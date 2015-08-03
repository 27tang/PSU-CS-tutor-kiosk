app.factory('entities', function($http){
    return {

        getStudents: function () {
            return $http({method:'GET', url: 'http://localhost:8080/students'})
                .success(function(data, status, headers, config){
                    return data;
                })
                .error(function(data, status, headers, config){
                    console.warn("getStudents failed");
                })
        },

        getStudent: function (studentId) {

            return $http({method: 'GET', url: 'http://localhost:8080/students/'+studentId}).
                success(function(data, status, headers, config) {
                    return data;
                }).
                error(function (data, status,headers, config){
                    console.log("FAILED for" + studentId)
                });
        },
        getTutors: function () {
            return $http({method:'GET', url: 'http://localhost:8080/tutors'})
                .success(function(data, status, headers, config){
                    return data;
                })
                .error(function(data, status, headers, config){
                    console.warn("getStudents failed");
                })
        },
        getTutor: function (listIndex, tutorId) {

            return $http({method: 'GET', url: 'http://localhost:8080/tutors/'+tutorId}).
                success(function(data, status, headers, config) {
                    return data;
                }).
                error(function (data, status,headers, config){
                    console.warn("getTutor failed for" + tutorId)
                });
        }
    };
});



