'use strict';

angular.module('MovieWebApp').controller('ActorController', ['$scope', 'ActorService', function ($scope, ActorService) {
    $scope.actor = {name: ''};

    function getActorDetails(actor) {
        ActorService.getActorDetails(actor)
            .then(
                function (value) {
                    $scope.actor.name = value.name;
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
                    $scope.actor.name = value.name;
                },
                function (errResponse) {
                    console.error('Error while searching for Actor');
                }
            )
    }

}]);