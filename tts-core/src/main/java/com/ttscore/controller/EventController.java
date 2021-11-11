package com.ttscore.controller;

import com.ttscore.model.Event;
import com.ttscore.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class EventController {
    @Autowired
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/all")
    List<Event> all() {
        return eventRepository.findAll();
    }
}