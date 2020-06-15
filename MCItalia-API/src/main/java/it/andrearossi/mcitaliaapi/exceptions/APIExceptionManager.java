package it.andrearossi.mcitaliaapi.exceptions;

public class APIExceptionManager {

	private final APIExceptionHandler handler;

	public APIExceptionManager() {
		this.handler = new DefaultExceptionHandler();
	}

	public APIExceptionManager(APIExceptionHandler handler) {
		this.handler = handler;
	}

	public APIExceptionHandler getHandler() {
		return handler;
	}
}
