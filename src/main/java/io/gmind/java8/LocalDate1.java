package io.gmind.java8;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Created by gmind on 14. 6. 23.
 */
@Slf4j
public class LocalDate1 {

    public static void main(String[] args){
        /**
         * LocalDate 는 2014-03-11 같은 특정 날짜를 표현한다.
         * 이 값은 불변이고, 아나로그를 LocalTime 으로의 처리이다.
         * 샘플 예제는 어떻게 새 날짜를 계산하는지 혹은 날짜,월 또는 년도를 분리하는지를 보여준다.
         * 각각의 조작은 새로운 인스턴스를 생성한다는걸 잊지 마라.
         */
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        log.debug("today : {}",today);
        log.debug("tomorrow : {}",tomorrow);
        log.debug("yesterday : {}",yesterday);

        LocalDate indenpendenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = indenpendenceDay.getDayOfWeek();
        log.debug("dayOfWeek: {}",dayOfWeek); // FRIDAY

        /**
         * 문자에서 부터 LocalDate 를 파싱하는것은 LocalTime 을 파싱하는것처럼 간단하다.
         */
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014",germanFormatter);
        log.debug("xmas : {}",xmas); // 2014-12-24
    }

}
