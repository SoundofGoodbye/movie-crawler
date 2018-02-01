package application.converters.apiservice;

import application.converters.Converter;
import application.models.actors.ActorDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToActorDetailsConverter implements Converter<String, ActorDTO> {

    @Override
    public ActorDTO convert(String resultAsJson) {
        ObjectMapper mapper = new ObjectMapper();
        ActorDTO actor = null;

        try {
            JsonNode rawActorsData = mapper.readValue(resultAsJson, JsonNode.class);
            String actorJsonString = rawActorsData.toString();
            actor = mapper.readValue(actorJsonString, ActorDTO.class);
        } catch (IOException e) {
            //TODO: Add log here
            e.printStackTrace();
        }

        return actor;
    }
}
