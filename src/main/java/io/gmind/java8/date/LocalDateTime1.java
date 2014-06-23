package io.gmind.java8.date;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * Created by gmind on 14. 6. 23.
 */
@Slf4j
public class LocalDateTime1 {

    public static void main(String[] args){
        /**
         * LocalDateTime 는 date-time 을 표현한다.
         * 이것은 위의 섹션에서 봤던 date 와 time 을 하나의 인스턴스 안에 합치는 것이다.
         * LocalDateTime 는 불변이고 LocalTime 과 LocalDate 와 유사하게 동작한다.
         * 우리는 date-time 으로 부터 정확한 필드를 검색하기 위한 수단으로 이용할 수 있다.
         */
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        log.debug("dayOfWeek : {}", dayOfWeek); // WEDNESDAY

        Month month = sylvester.getMonth();
        log.debug("month : {}", month); // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        log.debug("minuteOfDay : {}", minuteOfDay); // 1439

        /**
         * timezone 의 추가적인 정보로 instant 로 컨버트 될 수 있다.
         * Instants 는 기존의 java.util.Date 타입으로 쉽게 컨버트 된다.
         */
        Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();

        Date legacyDate = Date.from(instant);
        log.debug("legacyDate : {}", legacyDate); // Wed Dec 31 23:59:59 CET 2014

        /**
         * 형식을 갖춘(Formatting)) date-times 는 형식을 갖춘 date 와 time 와 유사하다.
         * pre-defined formats 을 사용하는 대신 우리는 custom 패턴들로 부터 formatter 를 생성할 수 있다.
         * ava.text.NumberFormat 와 달리 새로운 DateTimeFormatter 는 스레드 세이프하고 불변이다.
         */
        String str = "1986-04-08 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        log.debug("legacyDate : {}", dateTime); // 1986-04-08T12:30

    }
}
