package it.andrearossi.mcitaliaapi.exceptions;

import it.andrearossi.mcitaliaapi.utils.DoubleRunnable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public abstract class APIExceptionHandler {

	enum ErrorCase {
		UNKNOWN,
		IO_EXCEPTION,
		REFLECTIVE_EXCEPTION
	}

	private final HashMap<ErrorCase, Exception> errorCase = new HashMap<>();

	public APIExceptionHandler() {
	}

	public APIExceptionHandler exception(Exception e) {
		ErrorCase tempCase = ErrorCase.UNKNOWN;

		if (e instanceof IOException) {
			tempCase = ErrorCase.IO_EXCEPTION;
		}

		if (e instanceof ReflectiveOperationException) {
			tempCase = ErrorCase.REFLECTIVE_EXCEPTION;
		}

		errorCase.put(tempCase, e);

		return this;
	}

	public void handle(DoubleRunnable<ErrorCase, Exception> doubleRunnable) {
		if (!errorCase.isEmpty()) {
			for (Map.Entry<ErrorCase, Exception> error : errorCase.entrySet()) {
				doubleRunnable.run(error.getKey(), error.getValue());
			}
		}
	}

	public abstract DoubleRunnable<ErrorCase, Exception> runnableAdapter();
}
