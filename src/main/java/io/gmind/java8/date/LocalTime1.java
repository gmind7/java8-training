package io.gmind.java8.date;

import lombok.extern.slf4j.Slf4j;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

/**
 * Created by gmind on 14. 6. 23.
 */
@Slf4j
public class LocalTime1 {

    public static void main(String[] args) {
        /**
         * Clock 는 현재의 날짜와 시간을 조회할수 있게 해준다.
         * Clock 은 timezone 을 인지하고, System.currentTimeMillis() 를 사용하는 대신, 현재의 milliseconds 를 가져온다.
         * 타임라인의 순간적인 지점(point) 도 class Instant 로 표현된다.
         * Instants 는 기존의 java.util.Date 오브젝트를 생성하기 위해 사용될 수 있다.
         */
        Clock clock = Clock.systemDefaultZone();
        long t0 = clock.millis();
        log.debug("t0 : {}", t0);

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);

        /**
         * Timezones 는 ZoneId 로 표현된다.
         * static factory method 로 쉽게 조회될 수 있다.
         * Timezones 는 offset 을 정의하는데 이는 instants(역주 앞에서 얘기했던 Instant) 와 로컬의 날짜와 시간을 서로 컨버팅하기위해 중요하다.
         */
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");

        log.debug("zone1 : {}",zone1.getRules());
        log.debug("zone2 : {}",zone2.getRules());

        /**
         * LocalTime 은 10pm 이나 17:30:15 처럼 timezone 없이 시간을 표현한다.
         * 다음은 위에 정의된 timezone을 위한 두개의 로컬시간을 만드는 예제이다.
         * 그러면 우리는 두 시간을 비교하고 두시간 간에 시간과 분이 얼마나 다른지 계산한다.
         */
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        log.debug("now1 : {}",now1);
        log.debug("now2 : {}",now2);

        log.debug("now1 is before now2 : {}",now1.isBefore(now2)); // false

        // create time
        LocalTime now = LocalTime.now();
        log.debug("now : {}",now);

        /**
         * LocalTime 은 시간 문자열 파싱을 포함한, 새로운 인스턴스의 생성을 간략화 하기 위한 다양한 factory method 와 함께 제공된다.
         */
        LocalTime late = LocalTime.of(23,59,59);
        log.debug("late: {}", late);

        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        log.debug("leetTime : {}", leetTime);
    }
}
