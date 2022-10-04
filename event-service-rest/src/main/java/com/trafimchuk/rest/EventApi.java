package com.trafimchuk.rest;

import com.trafimchuk.dto.Event;
import com.trafimchuk.dto.EventDto;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RequestMapping("/api/v1/events")
public interface EventApi {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    EventModel createEvent(@RequestBody EventDto eventDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    EventModel updateEvent(@RequestBody EventDto eventDto);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    EventModel getEventById(@PathVariable long id);

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEvent(@PathVariable long id);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    ResponseEntity<List<Event>> getAllEvents();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{title}")
    ResponseEntity<List<Event>> getEventsByTitle(@PathVariable String title);

}