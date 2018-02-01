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
        return call(SEARCH_TYPE, query);
    }

    function searchActor(query) {
        return call(SEARCH_OPTION, query);
    }

    function call(address, query) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + address + "?q=" + query)
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