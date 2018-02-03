'use strict';

angular.module('MovieWebApp').controller('ActorController', ['$scope', 'ActorService', 'Actor', function ($scope, ActorService, Actor) {
    $scope.actor = new Actor();

    getActorDetails("100");
    searchActor("Johnny Depp");

    function getActorDetails(query) {
        console.log("Controller");
        ActorService.getActorDetails(query)
            .then(
                function (value) {
                    $scope.actor = value;
                },
                function (errResponse) {
                    console.error('Error while fetching Actor details');
                }
            )
    }

    function searchActor(query) {
        ActorService.searchActor(query)
            .then(
                function (value) {
                    $scope.Actor = value;
                },
                function (errResponse) {
                    console.error('Error while searching for Actor');
                }
            )
    }

}]);