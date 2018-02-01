'use strict';

App.factory('Actor', [function () {
    /**
     * Constructor, with class name
     */
    function Actor(id, name, age, birthday, biography) {
        // Public properties, assigned to the instance ('this')
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.biography = biography;
    }

    /**
     * Static method, assigned to class
     * Instance ('this') is not available in static context
     */
    Actor.build = function (data) {
        return new Actor(
            data.id,
            data.name,
            data.age,
            data.birthday,
            data.biography
        );
    };

    /**
     * Return the constructor function
     */
    return Actor;
}]);