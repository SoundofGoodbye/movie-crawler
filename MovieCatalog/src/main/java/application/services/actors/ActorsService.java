package application.services.actors;

public interface ActorsService {
    String getActor(String query, String language, int page, boolean includeAdult, String region);
}
