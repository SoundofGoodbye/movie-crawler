package application.converters.apiservice;

import application.converters.Converter;
import application.models.actors.ActorDTO;
import application.models.movies.MovieDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToActorConverter implements Converter<String, ActorDTO> {
    @Override
    public ActorDTO convert(String resultAsJson) {
        ObjectMapper mapper = new ObjectMapper();
        ActorDTO actor = null;

        try {
            JsonNode rawActorsData = mapper.readValue(resultAsJson, JsonNode.class);
            JsonNode actorJsonNode = rawActorsData.get("results").get(0);
            String actorJsonString = actorJsonNode.toString();
            actor = mapper.readValue(actorJsonString, ActorDTO.class);
        } catch (IOException e) {
            //TODO: Add log here
            e.printStackTrace();
        }

        return actor;
    }
}
