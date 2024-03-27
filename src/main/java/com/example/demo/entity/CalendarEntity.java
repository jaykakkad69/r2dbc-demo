package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "calendar_meta")
@Data
public class CalendarEntity implements Serializable {

    @Id
    @Column("calendar_date")
    private LocalDate date;

    @Column("com_yr_wk")
    private short walmartYearWeek;

    @Column("com_start_date")
    private LocalDate weekStartDate;

}
