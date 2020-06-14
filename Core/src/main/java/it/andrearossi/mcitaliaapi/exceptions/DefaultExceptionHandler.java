package it.andrearossi.mcitaliaapi.exceptions;

import it.andrearossi.mcitaliaapi.utils.DoubleRunnable;

public class DefaultExceptionHandler extends APIExceptionHandler {
	@Override
	public DoubleRunnable<ErrorCase, Exception> runnableAdapter() {
		return (errorCase, exception) -> exception.printStackTrace();
	}
}
