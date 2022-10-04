package com.trafimchuk.rest;

import com.trafimchuk.dto.EventDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventModelAssembler extends RepresentationModelAssemblerSupport<EventDto, EventModel> {

    public EventModelAssembler() {
        super(EventController.class, EventModel.class);
    }

    @Override
    public EventModel toModel(EventDto entity) {
        EventModel eventModel = new EventModel(entity);

        Link update = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                        .methodOn(EventController.class)
                        .updateEvent(entity))
                .withRel("getEventsByTitle");

        Link eventById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                        .methodOn(EventController.class)
                        .getEventById(entity.getId()))
                .withRel("getEventById");

        Link createEvent = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                        .methodOn(EventController.class)
                        .createEvent(entity))
                .withRel("createEvent");

        Link deleteEvent = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                        .methodOn(EventController.class)
                        .deleteEvent(entity.getId()))
                .withRel("deleteEvent");

        eventModel.add(createEvent, eventById, update, deleteEvent);
        return eventModel;
    }
}