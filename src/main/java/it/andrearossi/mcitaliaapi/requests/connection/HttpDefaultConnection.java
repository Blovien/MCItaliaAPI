package it.andrearossi.mcitaliaapi.requests.connection;

import it.andrearossi.mcitaliaapi.MCItaliaAPI;
import it.andrearossi.mcitaliaapi.utils.RunnableVal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Objects;

public class HttpDefaultConnection extends HttpAbstractConnection<StringBuilder> {

	public HttpDefaultConnection(String url, String userAgent, String version) {
		super(url, userAgent, version, StringBuilder.class);
	}

	public HttpDefaultConnection(String url) {
		super(url, StringBuilder.class);
	}

	public RunnableVal<HttpURLConnection, StringBuilder> runnableAdapter() {

		return new RunnableVal<HttpURLConnection, StringBuilder>() {
			@Override
			public void run(HttpURLConnection connection) {
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
					String temp;

					while ((temp = reader.readLine()) != null) {
						Objects.requireNonNull(getValue()).append(temp);
					}

				} catch (IOException e) {
					MCItaliaAPI.getExceptionHandler().exception(e).handle();
				}
			}
		};
	}
}
