'use strict';

angular.module('MovieWebApp').controller('MovieController', ['$scope', 'MoviesService', function($scope, MoviesService) {
    var self = this;
    $scope.movie={title:'',year:'',actors: []};
    $scope.movies=[];

    fetchMovie('Spider-Man');

    function fetchMovie(movie){
        MoviesService.fetchMovie(movie)
            .then(
                function(d) {
                    $scope.movies = d;
                },
                function(errResponse){
                    console.error('Error while fetching Movies');
                }
            );
    }
}]);