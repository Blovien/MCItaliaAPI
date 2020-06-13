package it.andrearossi.mcitaliaapi.exceptions;

import it.andrearossi.mcitaliaapi.utils.DoubleRunnable;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public class MCItaliaAPIExceptionHandler {

	enum ErrorCase {
		UNKNOWN,
		URL_EXCEPTION,

	}

	private HashMap<ErrorCase, StackTraceElement[]> errorCase;

	public MCItaliaAPIExceptionHandler() {
	}

	public MCItaliaAPIExceptionHandler exception(Exception e) {
		ErrorCase tempCase = ErrorCase.UNKNOWN;

		if (e instanceof MalformedURLException) {
			tempCase = ErrorCase.URL_EXCEPTION;
		}

		errorCase.put(tempCase, e.getStackTrace());

		return this;
	}

	public void handle(DoubleRunnable<ErrorCase, StackTraceElement[]> doubleRunnable) {
		if (!errorCase.isEmpty()) {
			for (Map.Entry<ErrorCase, StackTraceElement[]> error : errorCase.entrySet()) {
				doubleRunnable.run(error.getKey(), error.getValue());
			}
		} else {
			/*
			TODO: cosa fare nel caso non ci siano errori da gestire?
			TODO: magari da un errore gestibile a sua volta da MCItaliaAPIExceptionHandler che avverte della assenza di errori
			 */
		}
	}
}
