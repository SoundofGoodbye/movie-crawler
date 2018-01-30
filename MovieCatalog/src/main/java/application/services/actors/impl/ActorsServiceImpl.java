package application.services.actors.impl;

import application.services.actors.ActorsService;
import com.apiservice.services.actors.TMDBActorsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("actorsService")
public class ActorsServiceImpl implements ActorsService {
    @Autowired
    private TMDBActorsSearchService actorsSearchService;

    @Override
    public String searchActor(final String query, final String language, int page, boolean includeAdult, final String region) {
        return actorsSearchService.getActor(query, language, page, includeAdult, region);
    }

    @Override
    public String getActor(final String actorId, final String language, final String appendToResponse) {
        return actorsSearchService.getActorDetails(actorId, language, appendToResponse);
    }
}
