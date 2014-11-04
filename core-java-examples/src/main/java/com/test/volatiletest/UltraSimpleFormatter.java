package com.test.volatiletest;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class UltraSimpleFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		return formatMessage(record);
	}
}