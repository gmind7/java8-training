package io.gmind.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

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
	}
}
