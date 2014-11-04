package com.test.volatiletest;

import java.util.logging.Logger;

public class MyLoggerFactory {

	public static Logger getSimplestLogger(String name) {
		Logger logger = Logger.getLogger(name);
		logger.setUseParentHandlers(false);
		logger.addHandler(new MyConsoleHandler());
		return logger;
	}

	public static Logger getSimplestLogger() {
		return getSimplestLogger("noname");
	}
}