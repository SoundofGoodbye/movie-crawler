'use strict';

angular.module('MovieWebApp').controller('MovieController', ['$scope', 'MoviesService', 'Movie', function ($scope, MoviesService, Movie) {
    $scope.movies = [];

    searchMovie('Spider-Man');
    getMovieDetails('100');

    function searchMovie(query) {
        MoviesService.searchMovie(query)
            .then(
                function (data) {
                    $scope.movies.push(Movie.build(data));
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
                    $scope.movies.push(Movie.build(data));
                },
                function (errResponse) {
                    console.error('Error while getting details for: ' + query);
                }
            )
    }
}]);