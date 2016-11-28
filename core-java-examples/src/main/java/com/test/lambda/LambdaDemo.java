package com.test.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>() {
			{
				add(new Person("Shakti", 29, "12345678"));
				add(new Person("Neha", 30, "87654321"));
			}
		};
		printPersonsWithInAgeRange(persons, LambdaDemo::someMethod);
		processElements(persons, (person) -> person.getAge() == 29, (person) -> person.getName(), (name) -> System.err.println(name));
		new PersonCheck() {

			@Override
			public boolean checkPerson(Person person) {
				// TODO Auto-generated method stub
				return false;
			}
		}.printCheckDescription();
	}

	private static void printPersonsWithInAgeRange(List<Person> persons, Predicate<Person> personChecker) {
		for (Person person : persons) {
			if (personChecker.test(person)) {
				System.err.println(person);
			}
		}
	}

	private static boolean someMethod(Person person) {
		return person.getAge() == 30;
	}

	private static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	@FunctionalInterface
	interface PersonCheck {
		boolean checkPerson(Person person);

		default void printCheckDescription() {
			System.err.println("This can be used to check description");
		}
	}
}
