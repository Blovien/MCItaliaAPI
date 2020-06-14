package it.andrearossi.mcitaliaapi.requests.connection;

import com.google.gson.JsonObject;
import it.andrearossi.mcitaliaapi.utils.RunnableVal;
import it.andrearossi.mcitaliaapi.utils.RunnableVal2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Consumer;

public class HttpConnection<T> {

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

	public T get(RunnableVal<HttpURLConnection, T> runnable, T t) {
		try {
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", userAgent + "/" + version);

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK)
				runnable.run(connection);

			return runnable.returnable;
		} catch (IOException e) { // | ProtocolException
			//TODO:
		}
		return null;
	}

	public T post(RunnableVal<HttpURLConnection, T> runnable, String param, T t) {
		try {
			connection.setRequestMethod("POST");
			connection.setRequestProperty("User-Agent", userAgent + "/" + version);

			connection.setDoOutput(true);
			OutputStream stream = connection.getOutputStream();
			stream.write(param.getBytes());
			stream.flush();
			stream.close();

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK)
				runnable.run(connection);

			return runnable.returnable;
		} catch (IOException e) { // | ProtocolException
			//TODO:
		}

		return null;
	}

	public URL toURL() throws MalformedURLException {
		return new URL(url);
	}

	public void setURL(String url) {
		this.url = url;
	}

}
