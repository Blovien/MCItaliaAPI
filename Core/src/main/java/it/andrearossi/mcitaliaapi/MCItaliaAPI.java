package it.andrearossi.mcitaliaapi;

import com.google.gson.Gson;
import it.andrearossi.mcitaliaapi.exceptions.MCItaliaAPIExceptionHandler;
import it.andrearossi.mcitaliaapi.server.Server;
import it.andrearossi.mcitaliaapi.server.User;

import java.util.HashMap;
import java.util.Map;

public class MCItaliaAPI {

	private static final MCItaliaAPI instance;

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
