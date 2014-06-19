package io.gmind.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Created by gmind on 2014-06-18.
 */
@Slf4j
public class Lambda1 {


	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		Collections.sort(names, new Comparator<String>() {
			@Override public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});

		/**
		 * 이런 익명의 오브젝트를 만드는것 대신 Java 8 은 람다표현식 같은 짧은 문법 이 제공한다.
		 * JSR 292: INVOKEDYNAMIC
		 * JSR 335: LAMBDA EXPRESSION
		 * http://en.wikipedia.org/wiki/List_of_JVM_languages
		 */
		Collections.sort(names, (String a, String b) -> {
			return b.compareTo(a);
		});

		/**
		 * 더 짧게도 가능하다.
		 */
		Collections.sort(names, (String a, String b) -> b.compareTo(a));

		Collections.sort(names, (a, b) -> b.compareTo(a));

		log.debug("names1: {}", names);

		List<String> names2 = Arrays.asList("perter", null, "anna", "mike", "xenia");
		names2.sort(Comparator.nullsLast(String::compareTo));

		log.debug("names2: {}", names2);

		List<String> names3 = null;
		
		Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));

		log.debug("names3: {}", names3);


	}

}
