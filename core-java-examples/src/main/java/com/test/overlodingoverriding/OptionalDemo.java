package com.test.overlodingoverriding;

import java.util.Optional;

public class OptionalDemo {
	public static void main(String[] args) {
		Optional<String> opt = Optional.ofNullable("hi");
		opt.ifPresent(System.out::printf);
	}
}
