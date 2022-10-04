package com.trafimchuk.rest;

import com.trafimchuk.api.EventService;
import com.trafimchuk.dto.Event;
import com.trafimchuk.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController implements EventApi {

    private final EventService eventService;
    private final EventModelAssembler eventModelAssembler;

    @Override
    public EventModel createEvent(EventDto eventDto) {
        EventDto event = eventService.createEvent(eventDto);
        return eventModelAssembler.toModel(event);
    }

    @Override
    public EventModel updateEvent(EventDto eventDto) {
        EventDto event = eventService.updateEvent(eventDto);
        return eventModelAssembler.toModel(event);
    }

    @Override
    public EventModel getEventById(long id) {
        EventDto event = eventService.getEvent(id);
        return eventModelAssembler.toModel(event);
    }

    @Override
    public ResponseEntity<Void> deleteEvent(long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Event>> getEventsByTitle(String title) {
        List<Event> eventsByTitle = eventService.getAllEventsByTitle(title);
        return new ResponseEntity<>(eventsByTitle, HttpStatus.OK);
    }
}