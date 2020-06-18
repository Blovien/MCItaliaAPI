package it.andrearossi.mcitaliaapi.server;

import it.andrearossi.mcitaliaapi.utils.html.JsonCategoryList;

public class ServerList extends JsonCategoryList<Server, ServerCategory> {

	public ServerList(String status, Server[] items, ServerCategory[] categories) {
		super(status, items, categories);
	}

	@Deprecated
	public ServerPlatform getPlatform() {
		return getItems()[0].getPlatform();
	}
}
