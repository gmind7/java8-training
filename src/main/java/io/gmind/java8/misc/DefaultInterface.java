package io.gmind.java8.misc;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by gmind on 2014-06-18.
 */
@Slf4j
/**
 * @author Benjamin Winterberg
 */
public class DefaultInterface {

	interface Formula {
		double calculate(int a);

		default double sqrt(int a) {
			return Math.sqrt(positive(a));
		}

		static int positive(int a) {
			return a > 0 ? a : 0;
		}
	}

	public static void main(String[] args) {

		/**
		 * Java 8 은 default 키워드를 이용함으로써 비-추상 메소드 를 인터페이스에 구현가능하게 해준다. Extension method 라고하며 여기 우리의 첫 예제가 있다.
		 * 인터페이스 Formula 의 추상 메소드 calculate 를 제외하고는 sqrt 메소드는 default 가 정의되어있다.
		 * 실제 클래스는 구현해야할 추상메소드 calculate만 갖는다.
		 * 디폴트 메소드인 sqrt 는 그냥 바로 쓸 수 있다.
		 * formula 는 익명 형태로 구현되어있다. sqrt(a*100) 같은 간단한 계산을 위한 코드 6줄이 있다.
		 * 다음섹션에서 보겠지만 Java 8 에서 싱글 메소드 오브젝트를 구현하는 근사한 방법이 있다.
		 */
		Formula formula1 = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};

		formula1.calculate(100);     // 100.0
		formula1.sqrt(-23);          // 0.0
		Formula.positive(-4);        // 0.0

		/**
		 * 인터페이스 Formula 는 각각의 formula 인스턴스들이나 익명의 오브젝트들에서도 액세스 가능한 default method 인 sqrt 를 정의 했다.
		 * 이것은 람다 표현식과는 동작하지 않는다.
		 * Default method 들은 람다표현식 안에서는 액세스될 수 없다. 다음의 코드는 컴파일 되지 않는다.
		 */
		//Formula formula2 = (a) -> sqrt( a * 100);
	}

}
