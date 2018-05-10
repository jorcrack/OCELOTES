package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Event;
import com.example.easynotes.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @PostMapping("/events")
    public Event createEvent(@Valid @RequestBody Event event) {
        return eventRepository.save(event);
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable(value = "id") Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", eventId));
    }

    @PutMapping("/events/{id}")
    public Event updateEvent(@PathVariable(value = "id") Long eventId,
                                           @Valid @RequestBody Event eventDetails) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", eventId));

        event.setNombre(eventDetails.getNombre());
        event.setDireccion(eventDetails.getDireccion());
        event.setSala(eventDetails.getSala());
       
        
        Event evento = eventRepository.save(event);
        return evento;
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable(value = "id") Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", eventId));

        eventRepository.delete(event);

        return ResponseEntity.ok().build();
    }
}
