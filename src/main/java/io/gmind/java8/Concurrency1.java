package io.gmind.java8;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by gmind on 2014-06-19.
 */
@Slf4j
public class Concurrency1 {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, UUID> concurrentHashMap = new ConcurrentHashMap<>();

		for(int i = 0; i < 100; i++) {
			concurrentHashMap.put(i, UUID.randomUUID());
		}

		int threshold = 1;

		concurrentHashMap.forEachValue(threshold, a-> log.debug("concurrentHashMap forEachValue: {}",a));

		concurrentHashMap.forEach((id, uuid) -> {
			if(id % 10 ==0) {
				log.debug("concurrentHashMap forEach id: {}, uuid : {}", id, uuid);
			}
		});

		// parallelismThreshold 병렬처리 임계값
		UUID searchResult = concurrentHashMap.search(threshold, (id, uuid) -> {
			if(String.valueOf(uuid).startsWith(String.valueOf(id))){
				log.debug("concurrentHashMap searchResult id: {}, uuid : {}", id, uuid);
				return uuid;
			}
			return null;
		});

		log.debug("searchResult : {}", searchResult);
	}

}
