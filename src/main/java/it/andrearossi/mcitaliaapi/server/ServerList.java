package it.andrearossi.mcitaliaapi.server;

import it.andrearossi.mcitaliaapi.utils.html.JsonCategoryList;

public class ServerList extends JsonCategoryList<ListedServer, ServerCategory> {

	public ServerList(String status, ListedServer[] items, ServerCategory[] categories) {
		super(status, items, categories);
	}

}
