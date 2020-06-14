package it.andrearossi.mcitaliaapi.requests.connection;

import it.andrearossi.mcitaliaapi.utils.RunnableVal;
import it.andrearossi.mcitaliaapi.utils.RunnableVal2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class HttpDefaultConnection extends HttpAbstractConnection<StringBuilder> {
	public HttpDefaultConnection(String url, String userAgent, String version, StringBuilder builder) {
		super(url, userAgent, version, builder);
	}

	public HttpDefaultConnection(String url, StringBuilder builder) {
		super(url, builder);
	}

	public RunnableVal<HttpURLConnection, StringBuilder> runnableAdapter(StringBuilder builder) {

		return new RunnableVal<HttpURLConnection, StringBuilder>() {
			@Override
			public void run(HttpURLConnection connection) {
				try {
					String temp;
					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

					while ((temp = reader.readLine()) != null) {
						builder.append(temp);
					}

					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
