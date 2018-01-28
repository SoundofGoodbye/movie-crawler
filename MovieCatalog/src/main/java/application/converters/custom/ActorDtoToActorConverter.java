package application.converters.custom;

import application.converters.Converter;
import application.entities.Actor;
import application.models.actors.ActorDTO;

public class ActorDtoToActorConverter implements Converter<ActorDTO, Actor> {
    @Override
    public Actor convert(ActorDTO resultAsJson) {
        Actor actor = new Actor();
        actor.setName(resultAsJson.getName());

        return actor;
    }
}
