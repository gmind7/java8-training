package io.gmind.java8.lambda;

import io.gmind.java8.model.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by gmind on 2014-06-18.
 */
@Slf4j
public class Lambda2 {

	@FunctionalInterface
	public static interface Converter<F, T> {
		T convert(F from);
	}

	static class Something {
		String startWith(String s) {
			return String.valueOf(s.charAt(0));
		}
	}

	interface PersonFactory<P extends Person> {
		P create(String firstName, String lastName);
	}

	public static void main(String[] args) {

		Converter<String, Integer> integerConverter1 = (from) -> Integer.valueOf(from);
		Integer converted1 = integerConverter1.convert("123");
		log.debug("converted1 : {}",converted1);

		/**
		 * method reference
		 * Java 8 은 :: 키워드를 통해 메소드나 생성자의 참조를 지나치게 할 수 있다.
		 * 위의 예제는 정적메소드 참조의 예를 보여준다. 하지만 또한 우리는 오브젝트의 메소드를 참조할 수 있다.
		 * 람다 표현식으로 outer scope 의 변수들을 액세스 하는것은 익명 오브젝트와 유사하다.
		 * 지역 outer scope 에서도 final 변수들뿐만 아니라 인스턴스 필드들과 정적 변수들 또한 액세스 가능하다.
		 * Lambda Scopes : 반드시 코드가 컴파일 되기 위해 암묵적으로 fianl 이어야 한다.
 		 */

		Converter<String, Integer> integerConverter2 = Integer::valueOf;
		Integer converted2 = integerConverter2.convert("123");
		log.debug("converted2 : {}",converted2);

		Something something = new Something();

		Converter<String, String> stringConverter = something::startWith;
		String converted3 = stringConverter.convert("Java");
		log.debug("converted3 : {}",converted3);

		/**
		 * constructor reference
		 * 우리는 Person::new 로 Person 생성자의 참조를 생성했다. 자바 컴파일러는 PersonFactory.create 의 시그니처 매칭을 통해 올바른 생성자를 자동적으로 고른다.
		 */
		PersonFactory<Person> personPersonFactory = Person::new;
		Person person = personPersonFactory.create("peter", "parker");

		log.debug("person : {}", person.toString());

	}

}
