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
        return LocalDate.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
    }

    public LocalDateTime millisToLocalDateTime(Long millis){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis),ZoneId.systemDefault());
    }

    public long localDateToMillis(LocalDate localDate){
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public long localDateTimeToMillis(LocalDateTime localDateTime){
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
