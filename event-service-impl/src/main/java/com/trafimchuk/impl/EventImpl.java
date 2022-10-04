package com.trafimchuk.impl;

import com.trafimchuk.api.EventService;
import com.trafimchuk.dto.Event;
import com.trafimchuk.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = fromEventDTOtoEvent(eventDto);
        return fromEventToDTO(eventRepository.save(event));
    }

    @Transactional
    @Override
    public EventDto updateEvent(EventDto eventDto) {
        return getEvent(eventDto.getId())
                .setTitle(eventDto.getTitle())
                .setPlace(eventDto.getPlace())
                .setSpeaker(eventDto.getSpeaker())
                .setEventType(eventDto.getEventType())
                .setDateTime(eventDto.getDateTime());
    }

    @Override
    public EventDto getEvent(long eventId) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new NullPointerException("There is no event with id" + eventId));

        return fromEventToDTO(event);
    }

    @Override
    public void deleteEvent(long eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return eventRepository.findAllByTitle(title);
    }

    public EventDto fromEventToDTO(Event event) {
        return new EventDto(
                event.getId(),
                event.getTitle(),
                event.getPlace(),
                event.getSpeaker(),
                event.getEventType(),
                event.getDateTime());
    }

    public Event fromEventDTOtoEvent(EventDto eventDto) {
        return new Event(
                eventDto.getId(),
                eventDto.getTitle(),
                eventDto.getPlace(),
                eventDto.getSpeaker(),
                eventDto.getEventType(),
                eventDto.getDateTime());
    }
}