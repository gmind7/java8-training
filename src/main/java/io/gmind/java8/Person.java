package io.gmind.java8;

import lombok.Data;

/**
 * Created by gmind on 2014-06-18.
 */
@Data
public class Person {

	String firstName;
	String lastName;

	Person() {}

	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
