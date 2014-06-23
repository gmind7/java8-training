package io.gmind.java8.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by gmind on 2014-06-19.
 */
@Slf4j
public class Lambda4 {

	static int outerStaticNum;

	int outerNum;

	/**
	 * Accessing fields and static variables
	 * 대조를 이루는 로컬변수들, 인스턴스 필드와 정적 변수들에 대해 우리는 람다 표현식 안에서 대해 read/write 접근을 가지고 있다.
	 * 이런 형태는 익명 오브젝트들때부터 알려져 온것이다.
	 */
	void testScopes(){

		/**
		 * 람다 표현식으로 outer scope 의 변수들을 액세스 하는것은 익명 오브젝트와 유사하다.
		 * 지역 outer scope 에서도 final 변수들뿐만 아니라 인스턴스 필드들과 정적 변수들 또한 액세스 가능하다.
		 * 우리는 람다표현식의 outer scope 를 통해 final 로컬 변수들을 읽을 수 있다.
		 * 그러나 익명 오브젝트들에게는 변수 num 은 final로 선언될 필요가 없다는점은 다르다. 이 코드또한 valid 하다.
		 * 그러나 num 은 반드시 코드가 컴파일 되기 위해 암묵적으로 fianl 이어야 한다. 다음의 코드는 컴파일 되지 않는다.
		 */
		int num = 1;
		Lambda2.Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
		String convert = stringConverter.convert(2);
		log.debug("stringConverter : {}", convert); //3

		Lambda2.Converter<Integer, String> stringConverter2 = (from) -> {
			// 역주, 암묵적으로 final 이므로 대입안됨
			// 람다표현식 내부에서 outerNum 에 값을 쓰는것도 역시 금지된다.
			outerNum = 13;
			return String.valueOf(from);
		};

		log.debug("outerNum : {}", outerNum); //0

		String[] array = new String[1];
		Lambda2.Converter<Integer, String> stringConverter3 = (from) -> {
			array[0] = "Hi there";
			return  String.valueOf(from);
		};

		stringConverter3.convert(23);
		log.debug("array: {}", array[0]); //Hi there

	}

	public static void main(String[] args) {
		new Lambda4().testScopes();
	}


}
