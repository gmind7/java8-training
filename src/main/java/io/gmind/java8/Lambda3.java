package io.gmind.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by gmind on 2014-06-18.
 */
@Slf4j
public class Lambda3 {

	@FunctionalInterface
	interface Fun{
		void foo();
	}

	public static void main(String[] args) {

		/**
		 * Predicates
		 * 는 단일 아규먼트를 받는 boolean(값) 함수이다.
		 * 이 인터페이스는 복합적 논리단어(and,or,negate)의 구성을 위한 다양한 default 메소드들을 가지고 있다.		 *
		 */

		Predicate<String> predicate = (s) -> s.length() > 0;

		boolean isTest = predicate.test("foo"); //true
		boolean isNegate = predicate.negate().test("test"); //false

		log.debug("Predicate => isTest : {}, isNegate: {}",isTest, isNegate);

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		log.debug("Predicate => nonNull : {}, isNull : {}", nonNull, isNull);

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();

		log.debug("isEmpty : {}, isNotEmpty : {}", isEmpty.toString(), isNotEmpty.toString());

		/**
		 * Functions
		 * 는 단일 아규먼트를 받아 결과를 만들어낸다.
		 * Default 메소드들은 다수의 함수들과 함께 엮기 위해 사용될 수 있다. (compose, andThen)
		 */
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		String backString = backToString.apply("123");

		log.debug("Function => backString : {}", backString);
	}

}
