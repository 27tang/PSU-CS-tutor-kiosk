
app.factory('helpList', function($http) {

    return {
        getHelpList: function () {
            return $http( {method: 'GET', url: 'http://localhost:8080/helplist'})
                .success(function (data, status, headers, config) {
                    console.log("get help list success");

                    return data;
                })
                .error(function (data) {
                    return data;
                });
        },

        postHelpList: function(newListEntry) {
            return $http({method: 'POST', url: 'http://localhost:8080/helplist', data: newListEntry})
                .success(function(data, status, headers, config){
                    console.log("Post Help List Entry Success");
                    return data;
                })
                .error(function(data, status, headers, config){
                    console.warn("PostFailed");
                    return data;
                })
        },

        putHelpListEntry: function(entryId, editedEntry) {
            console.log("ENTRY ID WHEN IN HTTPCALL: " + entryId);
            return $http({method: 'PUT', url: 'http://localhost:8080/helplist/' + entryId, data: editedEntry})
                .success(function(data, status, headers, config){
                    return data;
            })
            .error(function(data, status, headers, config){
                    console.warn("Put failed for: " + entryId);
                    return data;
                })
        },

        deleteHelpListEntry: function(entryId) {
            return $http({method: 'DELETE', url: 'http://localhost:8080/helplist/' + entryId})
                .success(function(data, status, headers, config){
                    return data;
                })
                .error(function(data, status, headers, config){
                    console.warn("DeleteFailed for "+ entryId);
                    return data;
                })
        }

    }
});

