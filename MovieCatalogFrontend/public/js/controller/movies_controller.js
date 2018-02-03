'use strict';

angular.module('MovieWebApp').controller('MovieController', ['$scope', 'MoviesService', 'Movie', function ($scope, MoviesService, Movie) {
    var POSTER_IMAGE_IMDB_URL = "http://image.tmdb.org/t/p/w780/";

    $scope.movie = new Movie();

    searchMovie('Spider-Man');
    getMovieDetails('100');

    function searchMovie(query) {
        MoviesService.searchMovie(query)
            .then(
                function (data) {
                    $scope.movie = data;
                    $scope.movie.poster_path = "http://image.tmdb.org/t/p/w780/" + data.poster_path;
                },
                function (errResponse) {
                    console.error('Error while searching for Movies with:' + query);
                }
            );
    }

    function getMovieDetails(query) {
        MoviesService.getMovieDetails(query)
            .then(
                function (data) {
                    $scope.movie = data;
                },
                function (errResponse) {
                    console.error('Error while getting details for: ' + query);
                }
            )
    }

}]);