package com.example.demo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalmartCalendarWeek {

        Integer walmartYearWeek;
        LocalDate walmartWeekStartDate;
}
