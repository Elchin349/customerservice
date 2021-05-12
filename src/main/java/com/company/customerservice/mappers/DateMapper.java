package com.company.customerservice.mappers;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class DateMapper {

    public LocalDate millisToLocalDate(Long millis) {
        if (millis != null)
            return LocalDate.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
        return null;
    }

    public LocalDateTime millisToLocalDateTime(Long millis) {
        if (millis != null)
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
        return null;
    }

    public Long localDateToMillis(LocalDate localDate) {
        if (localDate != null)
            return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return null;
    }

    public Long localDateTimeToMillis(LocalDateTime localDateTime) {
        if (localDateTime != null)
            return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return null;
    }
}
