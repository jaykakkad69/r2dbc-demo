package com.example.demo.repository;

import com.example.demo.dao.WalmarCalendarWeek;
import com.example.demo.dao.WalmartCalendarWeek;
import com.example.demo.entity.CalendarEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface CalendarRepository extends R2dbcRepository<CalendarEntity, LocalDate> {

    @Query("""
           SELECT DISTINCT ON (com_yr_wk) com_yr_wk as walmar_year_week, com_start_date as walmart_week_start_date
           FROM calendar_meta
           WHERE calendar_date BETWEEN :startDate AND :endDate
           ORDER BY com_yr_wk
            """)
    Flux<WalmarCalendarWeek> findWalmarYearWeekDistinctByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("""
           SELECT DISTINCT ON (com_yr_wk) com_yr_wk as walmart_year_week, com_start_date as walmart_week_start_date
           FROM calendar_meta
           WHERE calendar_date BETWEEN :startDate AND :endDate
           ORDER BY com_yr_wk
            """)
    Flux<WalmartCalendarWeek> findWalmartYearWeekDistinctByDateBetween(LocalDate startDate, LocalDate endDate);

}
