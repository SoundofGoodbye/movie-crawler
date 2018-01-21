'use strict';

angular.module('MovieWebApp').factory('MoviesService', ['$http', '$q', function($http, $q){
    var REST_SERVICE_URI = 'http://localhost:8080/MovieWebApplication/movies{id}';

    var factory = {
        fetchAllMoviesFrom: fetchAllMoviesFrom,
    };

    return factory;

    function fetchAllMoviesFrom(sourceId) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "/" + sourceId)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching Users');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);