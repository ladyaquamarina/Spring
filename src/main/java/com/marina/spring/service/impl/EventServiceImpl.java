package com.marina.spring.service.impl;

import java.util.List;

import com.marina.spring.exception.BadRequestException;
import com.marina.spring.exception.EventNotFoundException;
import com.marina.spring.repository.EventRepository;
import com.marina.spring.repository.FileRepository;
import com.marina.spring.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.marina.spring.model.Event;
import com.marina.spring.model.File;
import com.marina.spring.model.User;
import com.marina.spring.service.EventService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final FileRepository fileRepository;

    public void createEvent(Integer userId, Integer fileId) {
        userRepository.findById(userId).orElseThrow(() -> new BadRequestException());
        fileRepository.findById(fileId).orElseThrow(() -> new BadRequestException());

        eventRepository.saveByIds(userId, fileId);
    }

    public List<Event> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events;
    }

    public void updateEvent(Integer id, String username, String filename) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException());
        User user = userRepository.findByUsername(username).orElseThrow(() -> new BadRequestException());
        File file = fileRepository.findByLocation(filename).orElseThrow(() -> new BadRequestException());
        event.setUser(user);
        event.setFile(file);

        eventRepository.save(event);
    }

    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }
}
