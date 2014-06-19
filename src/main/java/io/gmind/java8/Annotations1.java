package io.gmind.java8;

import java.lang.annotation.*;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by gmind on 2014-06-19.
 */
@Slf4j
public class Annotations1 {

	/**
	 * java 8 에서의 어노테이션 이용은 2개의 새로운 타겟으로 확장됐다.
	 */
	@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
	@interface MyAnnotation {

	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@interface Hints {
		Hint[] value();
	}

	@Repeatable(Hints.class)
	@Retention(RetentionPolicy.RUNTIME)
	@interface Hint {
		String value();
	}

	/**
	 * java 8 은 @Repeatable 어노테이션을 선언함으로써 같은 타입의 어노테이션들을 동시에 사용 가능하게 해준다.	 *
	 */
	@Hint("hint1")
	@Hint("hint2")
	class Person {

	}

	public static void main(String[] args) {

		/**
		 * java 8 의 Annotations 는 반복될 수 있다. 바로 예제로 확인해보자.
		 * 우선, 실제 어노테이션들의 배열로 을 가진 래퍼 어노테이션을 정의한다.
		 */

		Hint hint = Person.class.getAnnotation(Hint.class);
		log.debug("hint : {}", hint);

		/**
		 * 자바 컴파일러는 암묵적으로 @Hints 어노테이션을 설정한다.
		 * 이것은 reflection 을 통해 어노테이션 정보를 읽기 위해 중요하다.
		 * 우리가 Person 클래스에 @Hints 를 선언하지 않아도 getAnnotation(Hints.class)를 통해 여전히 읽을 수 있다.
		 * 그러나 @Hint 어노테이션 적용된 모든 것에 대해 직접액세스 가능하게 하는 getAnnotationsByType 어노테이션이 좀 더 편리하다
		 */
		Hints hints1 = Person.class.getAnnotation(Hints.class);
		log.debug("hitns1 length : {}", hints1.value().length); //2

		Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
		log.debug("hitns2 length : {}", hints2.length);
	}
}
