'use strict';

angular.module('MovieWebApp').controller('MovieController', ['$scope', 'MoviesService', function($scope, MoviesService) {
    var self = this;
    var POSTER_IMAGE_IMDB_URL = "http://image.tmdb.org/t/p/w780/";

    $scope.movie={title:'',poster_path:'',release_date:'',actors: [],overview:''};

    fetchMovie('Spider-Man');

    function fetchMovie(movie){
        MoviesService.fetchMovie(movie)
            .then(
                function(d) {
                    $scope.movie.title = d.title;
                    $scope.movie.poster_path = POSTER_IMAGE_IMDB_URL + d.poster_path;
                    $scope.movie.release_date = d.release_date;
                    $scope.movie.overview = d.overview;
                },
                function(errResponse){
                    console.error('Error while fetching Movies');
                }
            );
    }
}]);