package it.andrearossi.mcitaliaapi.requests.connection;

import it.andrearossi.mcitaliaapi.utils.RunnableVal;
import it.andrearossi.mcitaliaapi.utils.RunnableVal2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class HttpDefaultConnection extends HttpConnection<StringBuilder> {
	public HttpDefaultConnection(String url, String userAgent, String version) {
		super(url, userAgent, version);
	}

	public HttpDefaultConnection(String url) {
		super(url);
	}

	@Override
	public StringBuilder get(RunnableVal<HttpURLConnection, StringBuilder> runnable, StringBuilder builder) {
		return super.get(defaultRunnable(builder), builder);
	}

	@Override
	public StringBuilder post(RunnableVal<HttpURLConnection, StringBuilder> runnable, String param, StringBuilder builder) {
		return super.post(defaultRunnable(builder), param, builder);
	}

	public RunnableVal<HttpURLConnection, StringBuilder> defaultRunnable(StringBuilder builder) {

		return new RunnableVal<HttpURLConnection, StringBuilder>() {
			@Override
			public void run(HttpURLConnection connection) {
				try {
					AtomicReference<String> temp = new AtomicReference<>();
					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

					for (temp.set(reader.readLine()); temp.get().isEmpty();) {
						builder.append(temp.get());
					}

					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
