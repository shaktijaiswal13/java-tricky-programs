package com.test.memory;

public class TestHeapSize {
	public static void main(String[] args) {
		System.err.println("max memory : "
				+ convertBytesToMegaBytes(Runtime.getRuntime().maxMemory())
				+ "mb");
		System.err.println("total memory (initial heap space approx.) : "
				+ convertBytesToMegaBytes(Runtime.getRuntime().totalMemory())
				+ "mb");
		System.err.println("free memory : "
				+ convertBytesToMegaBytes(Runtime.getRuntime().freeMemory())
				+ "mb");
		System.err.println("used memory : "
				+ convertBytesToMegaBytes(Runtime.getRuntime().totalMemory()
						- Runtime.getRuntime().freeMemory()) + "mb");
	}

	private static double convertBytesToMegaBytes(long bytes) {
		double megaBytes = bytes / (1024 * 1024);
		return megaBytes;
	}
}
