package it.andrearossi.mcitaliaapi;

import it.andrearossi.mcitaliaapi.requests.connection.HttpDefaultConnection;
import it.andrearossi.mcitaliaapi.utils.Constants;

public final class MCItaliaCache {

	static {
		// CACHE INITIALIZATION

		HttpDefaultConnection connection = new HttpDefaultConnection(Constants.CRAFTING_LIST_URL);

		MCItaliaCache.CRAFTING_JSON_LIST = connection.get().toString();
	}

	private MCItaliaCache() {}

	public static String CRAFTING_JSON_LIST;
}
