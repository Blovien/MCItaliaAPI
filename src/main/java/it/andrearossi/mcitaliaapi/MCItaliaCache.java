package it.andrearossi.mcitaliaapi;

import it.andrearossi.mcitaliaapi.crafting.CraftingList;
import it.andrearossi.mcitaliaapi.news.NewsList;
import it.andrearossi.mcitaliaapi.requests.connection.HttpJsonConnection;
import it.andrearossi.mcitaliaapi.server.ServerList;
import it.andrearossi.mcitaliaapi.utils.Constants;

import java.util.Timer;
import java.util.TimerTask;

import static it.andrearossi.mcitaliaapi.MCItaliaAPI.fromJson;

public final class MCItaliaCache {

	private final Timer timer = new Timer();

	public static CraftingList CRAFTING_JSON_LIST;
	public static ServerList SERVER_JAVA_JSON_LIST, SERVER_BEDROCK_JSON_LIST;
	public static NewsList NEWS_JSON_LIST;

	protected MCItaliaCache() {}

	protected void init(Long delay) {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				update();
			}
		}, delay == null ? (24*60*60*1000L) : delay);
	}

	public static void update() {
		HttpJsonConnection connection = new HttpJsonConnection(Constants.CRAFTING_LIST_URL);

		CRAFTING_JSON_LIST = fromJson(connection.get(), CraftingList.class);
		connection.update(Constants.SERVER_LIST_URL + "java");
		SERVER_JAVA_JSON_LIST = fromJson(connection.get(), ServerList.class);
		connection.update(Constants.SERVER_LIST_URL + "bedrock");
		SERVER_BEDROCK_JSON_LIST = fromJson(connection.get(), ServerList.class);
		connection.update(Constants.NEWS_LIST_URL);
		NEWS_JSON_LIST = fromJson(connection.get(), NewsList.class);
	}
}
