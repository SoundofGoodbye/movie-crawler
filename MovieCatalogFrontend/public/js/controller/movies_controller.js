'use strict';

angular.module('MovieWebApp').controller('MovieController', ['$scope', 'MoviesService', function($scope, MoviesService) {
    var self = this;
    self.movie={title:'',year:'',actors: []};
    self.movies=[];

    fetchMovie('Spider-Man');

    function fetchMovie(movie){
        MoviesService.fetchMovie(movie)
            .then(
                function(d) {
                    self.movies = d;
                },
                function(errResponse){
                    console.error('Error while fetching Movies');
                }
            );
    }
}]);