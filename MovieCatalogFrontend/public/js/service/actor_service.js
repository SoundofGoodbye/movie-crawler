'use strict';

angular.module('MovieWebApp').factory('ActorService', ['$http', '$q', function ($http, $q) {
    var REST_SERVICE_URI = 'http://localhost:8080/actors';
    var SEARCH_OPTION = '/search';
    var SEARCH_TYPE = '/actor';


    var factory = {
        getActorDetails: getActorDetails,
        searchActor: searchActor
    };

    return factory;

    function getActorDetails(query) {
        var url = SEARCH_TYPE + "?actorId=" + query;
        return call(url);
    }

    function searchActor(query) {
        var url = SEARCH_OPTION + "?q=" + query;
        return call(url);
    }

    function call(query) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + query)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                }, function (errResponse) {
                    console.error('Error while fetching Actor');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);