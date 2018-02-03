'use strict';

App.factory('Movie', [function () {
    /**
     * Constructor, with class name
     */

    function Movie(id, title, poster_path, overview, release_date) {
        this.id = id;
        this.title = title;
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
    }

    /**
     * Static method, assigned to class
     * Instance ('this') is not available in static context
     */
    Movie.build = function (data) {
        return new Movie(
            data.id,
            data.title,
            data.poster_path,
            data.overview,
            data.release_date
        );
    };

    return Movie;
}]);