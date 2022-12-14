package com.trafimchuk.impl;

import com.trafimchuk.dto.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAll();
    List<Event> findAllByTitle(String title);
}