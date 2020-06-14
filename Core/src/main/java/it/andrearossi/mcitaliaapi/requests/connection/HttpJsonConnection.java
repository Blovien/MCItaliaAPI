package it.andrearossi.mcitaliaapi.requests.connection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.andrearossi.mcitaliaapi.MCItaliaAPI;
import it.andrearossi.mcitaliaapi.utils.RunnableVal;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class HttpJsonConnection extends HttpAbstractConnection<JsonObject> {
	public HttpJsonConnection(String url, String userAgent, String version) {
		super(url, userAgent, version, JsonObject.class);
	}

	public HttpJsonConnection(String url) {
		super(url, JsonObject.class);
	}

	@Override
	public RunnableVal<HttpURLConnection, JsonObject> runnableAdapter() {
		return new RunnableVal<HttpURLConnection, JsonObject>() {
			@Override
			public void run(HttpURLConnection connection) {
				try {
					Scanner scanner = new Scanner(connection.getURL().openStream());
					String json = scanner.useDelimiter("\\Z").next();
					JsonElement jsonElement = MCItaliaAPI.getGson().fromJson(json, JsonElement.class);
					setValue(jsonElement.getAsJsonObject());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
