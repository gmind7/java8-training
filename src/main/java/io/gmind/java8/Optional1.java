package io.gmind.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * Created by gmind on 2014-06-19.
 */
@Slf4j
public class Optional1 {

	public static void main(String[] args) {

		/**
		 * Optionals 은 함수인터페이스가 아니고 NullPointerException 을 막는 멋진 유틸리티이다.
		 * 이것은 다음섹션을 위해서 중요한 컨셉인데, Optionals이 어떻게 동작하는지 간단히 살펴보자.
		 * Optional 은 null 이나 non-null 을 수 있는 값을 위한 간단한 컨테이너이다.
		 * 보통은 non-null 을 리턴하지만 가끔은 아무것도 리턴하지 않는 메소드를 생각해보자.
		 * Java 8 에서는 null 을 리턴하는대신 Optional 을 리턴할 수 있다.
		 */
		Optional<String> optional = Optional.of("bam");

		log.debug("optional.isPresent() : {}", optional.isPresent()); //true
		log.debug("optional.get() : {}", optional.get()); //bam
		log.debug("optional.orElse(\"fallback\"): {}", optional.orElse("fallback")); //bam

		optional.ifPresent((s) -> log.debug("s.charAt(0) : {}", s.charAt(0))); //b
	}
}
