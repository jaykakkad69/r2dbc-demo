package com.example.demo.controller;

import com.example.demo.dao.WalmarCalendarWeek;
import com.example.demo.dao.WalmartCalendarWeek;
import com.example.demo.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@RestController
public class CalendarController {

    @Autowired
    private CalendarRepository calendarRepository;

    @GetMapping("/error")
    public Flux<WalmartCalendarWeek> getError() {
        return calendarRepository.findWalmartYearWeekDistinctByDateBetween(LocalDate.of(2024, 3, 27),
                LocalDate.of(2024,4,15)).log();
    }

    @GetMapping("/success")
    public Flux<WalmarCalendarWeek> getSuccess() {
        return calendarRepository.findWalmarYearWeekDistinctByDateBetween(LocalDate.of(2024, 3, 27),
                LocalDate.of(2024,4,15)).log();
    }
}
