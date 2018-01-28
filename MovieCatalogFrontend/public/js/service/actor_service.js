'use strict';

angular.module('MovieWebApp').factory('ActorService', ['$http', '$q', function($http, $q){
    var REST_SERVICE_URI = 'http://localhost:8080/actors/search';

    var factory = {
        fetchActor: fetchActor,
    };

    return factory;

    function fetchActor(query) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "/" + "?q=" + query)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching Actor');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);