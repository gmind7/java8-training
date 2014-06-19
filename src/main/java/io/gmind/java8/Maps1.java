package io.gmind.java8;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

/**
 * Created by gmind on 2014-06-19.
 */
@Slf4j
public class Maps1 {

	public static void main(String[] args){

		Map<Integer, String> map = new HashMap<>();

		for(int i=0; i<10; i++){
			map.putIfAbsent(i, "val"+i);
		}

		/**
		 * map은 stream 을 지원하지 않는다고 앞에서 언급했다.
		 * 이런일 처리를 위해 map 대신 이제 다양한 새롭고 유용한 methods 들을 제공한다.
		 */
		map.forEach((id, val) -> log.debug("map forEcah : key: {}, value: {}", id, val)); //map forEcah : key: 0, value: val0 ..

		/**
		 * putIfAbsent 는 null 체크를 추가하는것을 방지해준다. forEach 는 map 의 각각의 값을 처리해줄 있도록 해준다.
		 * 다음의 예는 유용한 함수를 통해 코드가 어떻게 해석되는지 보여준다.
		 */
		map.computeIfPresent(3, (num, val) -> val + num);
		log.debug("map.get(3):{}", map.get(3)); //val33

		map.computeIfPresent(9, (num, val) -> null);
		log.debug("map.containsKey(9):{}", map.containsKey(9)); //false

		map.computeIfAbsent(23, num -> "val" + num);
		log.debug("map.containsKey(23):{}", map.containsKey(23)); //true

		map.computeIfAbsent(3, num -> "bam");
		log.debug("map.get(3):{}", map.get(3)); //val33

		/**
		 * 또 다른 유용한 메소드로
		 */
		log.debug("map.getOrDefault(42, \"not found\")", map.getOrDefault(42, "not found")); //not found

		/**
		 * 다음은, 주어진 키와 키에 맵핑된 값에 대해서만 삭제하는 방법을 보여준다.
		 */
		map.remove(3, "val3");
		log.debug("map.get(3) : {}",map.get(3)); //val33

		map.remove(3, "val33");
		log.debug("map.get(3) : {}",map.get(3)); //null

		/**
		 * map 의 전체 병합은 아주 쉽다.
		 * 키가 엔트리에 존재하지 않을경우 키/값 을 map에 넣거나 기존의 값을 바꾸기 위해 머지 함수가 호출될 것이다.
		 */
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		log.debug("map.merge to map.get(9): {}",map.get(9)); //val9

		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		log.debug("map.merge to map.get(9): {}",map.get(9)); //val9concat
	}
}
