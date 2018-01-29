'use strict';

angular.module('MovieWebApp').controller('ActorController', ['$scope','ActorService',  function($scope,ActorService) {
    var self = this;
    $scope.actor={name:''};

    fetchActor('Johnny Depp');

    function fetchActor(actor) {
        ActorService.fetchActor(actor)
            .then(
                function (value) {
                    $scope.actor.name = value.name;
                },
                function(errResponse){
                    console.error('Error while fetching Actor');
                }
            )

    }
}]);