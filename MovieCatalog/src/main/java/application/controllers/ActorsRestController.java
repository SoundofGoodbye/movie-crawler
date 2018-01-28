package application.controllers;

import application.converters.Converter;
import application.converters.apiservice.JsonToActorConverter;
import application.models.actors.ActorDTO;
import application.services.actors.ActorsService;
import com.apiservice.services.actors.TMDBActorsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ActorsRestController")
@RequestMapping(value = "/actors")
public class ActorsRestController {

    @Autowired
    private ActorsService actorsService;

    @RequestMapping(value = "/search")
    public ResponseEntity<ActorDTO> searchActor(@RequestParam(value = "q", required = true) final String query,
                                                @RequestParam(value = "lang", required = false) final String language,
                                                @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                @RequestParam(value = "include_adult", required = false) boolean includeAdult,
                                                @RequestParam(value = "region", required = false) final String region) {

        String jsonActorResult = actorsService.getActor(query, language, page, includeAdult, region);
        Converter<String, ActorDTO> converter = new JsonToActorConverter();
        return new ResponseEntity<>(converter.convert(jsonActorResult), HttpStatus.OK);
    }
}
