package io.gmind.java8.stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by gmind on 2014-06-19.
 */
@Slf4j
public class Streams4 {

	public static void main(String[] args){

		for(int i=0; i< 10; i++){
			if(i%2==1) {
				log.debug("jdk7 for i : {}",i);
			}
		}

		/**
		 * Range
		 */
		IntStream.range(0, 10)
			.forEach(i -> {
				if(i%2 == 1) {
					log.debug("IntStream range1 : {}",i);
				}
			});

		IntStream.range(0, 10)
			.filter((i -> i%2 == 1))
			.forEach(a -> log.debug("IntStream range2 : {}",a));

		OptionalInt reduced1 =IntStream.range(0,10).reduce((a,b) -> a+b);
		log.debug("OptionalInt reduced1 : {}",reduced1.getAsInt());

		/**
		 * int reduce(int identity, IntBinaryOperator op);
		 * 3은 항등식
		 */
		int reduced2 = IntStream.range(0,10).reduce(3, (a,b) -> a+b);
		log.debug("int reduced2 : {}",reduced2);
	}
}
