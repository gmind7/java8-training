package io.gmind.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import javax.swing.text.html.Option;

/**
 * Created by gmind on 2014-06-19.
 */
@Slf4j
public class Streams1 {

	public static void main(String[] args) {

		/**
		 * Built-in Functional Interfaces
		 * JDK 1.8 API 는 많은 빌트인 함수 인터페이스를 가지고 있다. 그중에는 과거의 자바버전에서 부터 알려저온 Comparator, Runnable 같은게 있다.
		 * 이런 존재하는 인터페이스들은 @FunctionalInterface 어노테이션을 통해 람다 지원이 가능하도록 확장된다.
		 * 그러나 Java 8 API 또한 당신의 삶을 좀더 쉽게 만들어줄 새로운 함수 인터페이스로 가득차있다.
		 * 몇몇 새로운 인트페이스들은 Google Guava 라이브러리에서 잘 알려진 것들이다.
		 * 이 라이브러리가 친숙하더라도 어떻게 저 인터페이스들이 유용한 메소드 확장들에 의해 확장됐는지 주시해야 한다.
		 */

		List<String> stringCollection = new ArrayList<>();

		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		/**
		 * Filtering
		 * Filter 는 스트림의 모든 요소들을 필터링 하는것을 처리한다.
		 * 이 기능은 결과에서의 또다른 stream 연산(e.g foreach)을 호출할수 있도록 해주는 intermediate(중개[연산자]) 이다.
		 * (역주. 중간자?) ForEach 는 필터링된 스트림의 원소 각각를 처리하게 해준다.
		 * ForEach 는 terminal(종단[연산자]) operation 이다. 이것은 void 이므로 또다른 stream operation 을 호출할 수 없다.
		 */
		stringCollection
			.stream()
			.filter((s) -> s.startsWith("a"))
			.forEach(a -> log.debug("Filtering : {}", a));

		/**
		 * Sorting
		 * Sorted 는 stream 의 sorted view 를 리턴해주는 intermediate operation 이다.
		 * 만약 임의의 Comparator 를 넘겨주지 않는다면 natural order 를 기준으로 elements 들이 정렬된다.
		 */
		stringCollection
			.stream()
			.sorted()
			.filter((s) -> s.startsWith("a"))
			.forEach(a -> log.debug("Sorting : {}", a));

		/**
		 * Mapping
		 * intermediate operation 인 map은 주어진 함수를 통해 각각의 element 를 또다른 오브젝트로 변환한다.
		 * 다음에 나오는 예제는 각각의 문자를 대문자로 변환한다.
		 * 허나 물론 또다른 타입으로 각각의 오브젝트를 변환하기 위해 map 을 사용할 수 도 있다.
		 * 생성되는 stream 제네릭 타입은 map 에 넘긴 함수의 제네릭타입에 따른다.
		 */
		stringCollection
			.stream()
			.map(String::toUpperCase)
			.sorted((a, b) -> b.compareTo(a))
			.forEach(a -> log.debug("Mapping : {}", a));

		// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"


		/**
		 * Match
		 * 다양한 매칭 연산들은 정확히 결정된 stream 매치인지를 체크하는데 사용된다. 이런 모든 연산들은 terminal 이고 boolean 결과를 리턴한다.
		 */
		boolean anyStartsWithA = stringCollection.stream().anyMatch((s) -> s.startsWith("a"));
		log.debug("Match anyStartsWithA : {}", anyStartsWithA); // true

		boolean allStartWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));
		log.debug("Match allStartWithA : {}", allStartWithA); // false

		boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));
		log.debug("Match noneStartsWithZ : {}", noneStartsWithZ); // true

		/**
		 * Count
		 * Count 는 stream의 다수의 element 들을 long 으로 돌려주는 terminal operation이다.
		 */
		long startsWithB = stringCollection.stream().filter((s) -> s.startsWith("b")).count();
		log.debug("Count startsWithB : {}", startsWithB); // 3

		/**
		 * Reduce
		 * Reduce terminal operation은 주어진 함수로 스트림의 elements 를 줄여주는 작업을 수행한다. 결과는 줄어든 값을 보유한 Optional 이다.
		 * Optionals 은 함수인터페이스가 아니고 NullPointerException 을 막는 멋진 유틸리티이다. 이것은 다음섹션을 위해서 중요한 컨셉인데, Optionals이 어떻게 동작하는지 간단히 살펴보자.
		 */
		Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(a -> log.debug("Reduce reduced : {}", a));

		//aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2
	}

}
