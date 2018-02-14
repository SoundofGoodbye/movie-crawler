'use strict';
angular.module('MovieWebApp')
    .directive('myDirective', function () {
        return {
            restrict: 'EA',
            scope: {
                title: '@'
            },
            controller: 'MovieController',
            templateUrl: 'templates/listCarousel.html',
            link: function (scope, element, attr) {
                scope.$watch(attr.watchMe, function (newValue, oldValue) {
                    //check new value to be what you expect.
                    if (newValue) {
                        console.log("test");
                    }
                });
            }
        }
    });
