package it.andrearossi.mcitaliaapi;

import it.andrearossi.mcitaliaapi.exceptions.MCItaliaAPIExceptionHandler;

public class MCItaliaAPI {

	private final static MCItaliaAPI instance;

	static {
		instance = new MCItaliaAPI();
	}

	private final MCItaliaAPIExceptionHandler exceptionHandler;

	public MCItaliaAPI() {
		this.exceptionHandler = new MCItaliaAPIExceptionHandler();
	}

	public static MCItaliaAPI getInstance() {
		return instance;
	}

	public MCItaliaAPIExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}
}
