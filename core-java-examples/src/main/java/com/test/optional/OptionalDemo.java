package com.test.optional;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		demoNullPointer();
	}

	private static void demoNullPointer() {
		Computer computer = new Computer();
		computer.soundCard=Optional.ofNullable(null);
		computer.soundCard.ifPresent(System.out::println);
		computer.soundCard=Optional.ofNullable(new SoundCard());
		computer.soundCard.ifPresent(System.out::println);
	}

	static class Computer {
		Optional<SoundCard> soundCard;
	}

	static class SoundCard {
		Optional<USB> usb;
	}

	static class USB {
		String version;
	}

}
