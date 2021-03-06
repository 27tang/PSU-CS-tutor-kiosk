
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
                    return data;
                })
                .error(function(data, status, headers, config){
                    console.warn("PostFailed");
                    return data;
                })
        },

        putHelpListEntry: function(entryId, editedEntry) {
            return $http({method: 'PUT', url: 'http//localhost:8080/helpList/' + entryId, data: editedEntry})
                .success(function(data, status, headers, config){
                    return data;
            })
            .error(function(data, status, headers, config){
                    console.warn("Put failed for: " + entryId);
                    return data;
                })
        },

        deleteHelpListEntry: function(entryId) {
            return $http({method: 'DELETE', url: 'http://localhost:8080/helpList/' + entryId})
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

