package it.andrearossi.mcitaliaapi.requests.connection;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Consumer;

public class HttpConnection {

	private HttpURLConnection connection;
	private String url;

	private String userAgent = "Mozilla";
	private String version = "5.0";

	public HttpConnection(String url, String userAgent, String version) {
		this.url = url;
		this.userAgent = userAgent;
		this.version = version;
	}

	public HttpConnection(String url) {
		this.url = url;
	}

	public void connect() {
		try {
			this.connection = (HttpURLConnection) toURL().openConnection();
		} catch (IOException e) {
			//TODO:
			// MCItaliaAPI.getInstance().getExceptionHandler()
			// 							.exception(e).handle(...);
		}
	}

	public void get(Consumer<HttpURLConnection> consumer) {
		try {
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", userAgent + "/" + version);

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK)
				consumer.accept(connection);
		} catch (IOException e) { // | ProtocolException
			//TODO:
		}
	}

	public void post(Consumer<HttpURLConnection> consumer, String param) {
		try {
			connection.setRequestMethod("POST");
			connection.setRequestProperty("User-Agent", userAgent + "/" + version);

			connection.setDoOutput(true);
			OutputStream stream = connection.getOutputStream();
			stream.write(param.getBytes());
			stream.flush();
			stream.close();

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK)
				consumer.accept(connection);

		} catch (IOException e) { // | ProtocolException
			//TODO:
		}
	}

	public URL toURL() throws MalformedURLException {
		return new URL(url);
	}

	public void setURL(String url) {
		this.url = url;
	}

}
