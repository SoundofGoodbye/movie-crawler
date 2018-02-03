package application.controllers;

import application.converters.Converter;
import application.converters.apiservice.JsonToActorConverter;
import application.converters.apiservice.JsonToActorDetailsConverter;
import application.models.actors.ActorDTO;
import application.services.actors.ActorsService;
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

        String jsonActorResult = actorsService.searchActor(query, language, page, includeAdult, region);
        Converter<String, ActorDTO> converter = new JsonToActorConverter();
        return new ResponseEntity<>(converter.convert(jsonActorResult), HttpStatus.OK);
    }

    @RequestMapping(value = "/actor")
    public ResponseEntity<ActorDTO> getActorDetails(@RequestParam(value = "actorId", required = true) final String actorId,
                                                    @RequestParam(value = "lang", required = false) final String language,
                                                    @RequestParam(value = "appendToReponse", required = false) final String appendToResponse) {

        String jsonActorResult = actorsService.getActor(actorId, language, appendToResponse);
        Converter<String, ActorDTO> converter = new JsonToActorDetailsConverter();
        return new ResponseEntity<>(converter.convert(jsonActorResult), HttpStatus.OK);
    }
}
