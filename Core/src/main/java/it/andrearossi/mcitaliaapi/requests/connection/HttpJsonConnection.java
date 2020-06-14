package it.andrearossi.mcitaliaapi.requests.connection;

import com.google.gson.JsonObject;
import it.andrearossi.mcitaliaapi.utils.RunnableVal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpJsonConnection extends HttpAbstractConnection<JsonObject> {
	public HttpJsonConnection(String url, String userAgent, String version, JsonObject object) {
		super(url, userAgent, version, object);
	}

	public HttpJsonConnection(String url, JsonObject object) {
		super(url, object);
	}

	@Override
	public RunnableVal<HttpURLConnection, JsonObject> runnableAdapter(JsonObject object) {
		return new RunnableVal<HttpURLConnection, JsonObject>() {
			@Override
			public void run(HttpURLConnection connection) {
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
