package com.trafimchuk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public class EventDto {

    private long id;
    private String title;
    private String place;
    private String speaker;
    private String eventType;
    private String dateTime;

}