package io.gmind.java8.model;

import lombok.Data;

/**
 * Created by gmind on 2014-06-18.
 */
@Data
public class Person {

	String firstName;
	String lastName;

	public Person() {
    }

    public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
