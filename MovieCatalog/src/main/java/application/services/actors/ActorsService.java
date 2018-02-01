package application.services.actors;

public interface ActorsService {
    String searchActor(final String query, final String language, int page, boolean includeAdult, final String region);

    String getActor(final String actorId, final String language, final String appendToResponse);
}
