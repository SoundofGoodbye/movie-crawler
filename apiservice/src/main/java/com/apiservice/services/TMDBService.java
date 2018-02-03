package com.apiservice.services;

public interface TMDBService {
    /**
     * Text based search is the most common way. You provide a query string and we provide the closest match.
     * Searching by text takes into account all original, translated, alternative names and titles.
     *
     * @return
     */
    String search(final String address, final String params);

    /**
     * Sometimes it useful to search for movies and TV shows based on filters or definable values like ratings,
     * certifications or release dates. The discover method make this easy.
     *
     * @return
     */
    public String discover();

    /**
     * The last but still very useful way to find data is with existing external IDs. For example, if you know the IMDB ID of a movie,
     * TV show or person, you can plug that value into this method and we'll return anything that matches.
     *
     * @return
     */
    public String find();

    String get(final String address, final String params);
}
