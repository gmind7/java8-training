package io.gmind.java8.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gmind on 2014-06-19.
 */
@Slf4j
public class Streams2 {

	public static void main(String[] arts) {

		List<String> stringCollection = new ArrayList<>();

		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		// sorting
		stringCollection.stream().sorted().forEach(a -> log.debug("forEach : {}", a));
        log.debug("stringCollection : {}", stringCollection);

        /**
         * collect
         * Collectors를 이용하여 map, set, list 형태로 결과를 리턴 받을 수 있다.
         */
        List<String> result = stringCollection.stream().sorted().collect(Collectors.toList());
        log.debug("Collect Result : {}", result.toString());
	}
}
