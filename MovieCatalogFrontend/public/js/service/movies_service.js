'use strict';

angular.module('MovieWebApp').factory('MoviesService', ['$http', '$q', function($http, $q){
    var REST_SERVICE_URI = 'http://localhost:8080/movies/search';

    var factory = {
        fetchMovie: fetchMovie,
    };

    return factory;

    function fetchMovie(query) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "/" + "?q=" + query)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching Movies');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);