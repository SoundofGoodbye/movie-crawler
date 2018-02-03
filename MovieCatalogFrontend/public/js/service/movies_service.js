'use strict';

angular.module('MovieWebApp').factory('MoviesService', ['$http', '$q', function($http, $q){
    var REST_SERVICE_URI = 'http://localhost:8080/movies';
    var SEARCH_OPTION = '/search';
    var SEARCH_TYPE = '/movie';

    var factory = {
        searchMovie: searchMovie,
        getMovieDetails: getMovieDetails
    };

    return factory;

    function searchMovie(query) {
        var url = SEARCH_OPTION + "?q=" + query;
        return call(url);
    }

    function getMovieDetails(query) {
        var url = SEARCH_TYPE + "?movieId=" + query;
        return call(url);
    }

    function call(query) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + query)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                }, function (errResponse) {
                    console.error('Error while fetching Movie');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);