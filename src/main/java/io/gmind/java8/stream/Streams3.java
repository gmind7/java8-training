package io.gmind.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by gmind on 2014-06-19.
 */
@Slf4j
public class Streams3 {

	public static final int MAX = 1000000;

	public static void sortSequential() {
		List<String> values = new ArrayList<>(MAX);
		for(int i=0; i < MAX; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		//sequential
		long t0 = System.nanoTime();

		long count = values.stream().sorted().count();
		log.debug("count : {}", count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		log.debug("sequential sort took: {} ms",String.format("%d", millis));

	}

	/**
	 * 위에서 언급한 streams 는 시퀀셜하거나 패러럴(병렬)이 될 수 있다.
	 * 시퀀셜 스트림의 연산은 싱글 스레드에서 처리되는 반면 패러럴 스트림에서의 연산은 멀티플 스레드에서 동시에 처리된다.
	 * 다음에 나오는 예제는 병렬 streams 를 이용해서 성능을 올리는게 얼마나 쉬운지 보여주고 있다.
	 * 우선 유니크한 elements 들의 커다란 리스트를 생성한다.
	 */
	public static void sortParaller(){
		List<String> values = new ArrayList<>(MAX);
		for(int i=0; i < MAX; i++){
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		//sequential
		long t0 = System.nanoTime();
		/**
		 * 두 코드를 봐서는 거의 비슷하나 parallel 정렬은 대략 50% 정도 빠르다. 해야할것은 stream() 을 parallelStream() 으로 바꾸는게 전부이다.
		 */
		long count = values.parallelStream().sorted().count();
		log.debug("count : {}", count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);

		log.debug("parallel sort took: {} ms",String.format("%d", millis));
	}

	public static void main(String[] args) {
		sortSequential();
		sortParaller();
	}
}