package it.andrearossi.mcitaliaapi.requests.connection;

import it.andrearossi.mcitaliaapi.utils.RunnableVal;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnection<T> {

	private HttpURLConnection connection;
	private String url;

	private T t;

	private final String userAgent;
	private final String version;

	public HttpConnection(String url, Class<T> t) {
		this(url, "Mozilla", "5.0", t);
	}

	public HttpConnection(String url, String userAgent, String version, Class<T> t) {
		this.url = url;
		this.userAgent = userAgent;
		this.version = version;

		try {
			this.t = t.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
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

	public T getRunnable(RunnableVal<HttpURLConnection, T> runnable) {
		try {
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", userAgent + "/" + version);

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				runnable.run(connection);
			}
		} catch (IOException e) { // | ProtocolException
			e.printStackTrace();
			//TODO:
		}
		return t;
	}

	public T postRunnable(RunnableVal<HttpURLConnection, T> runnable, String param) {
		try {
			connection.setRequestMethod("POST");
			connection.setRequestProperty("User-Agent", userAgent + "/" + version);

			connection.setDoOutput(true);
			OutputStream stream = connection.getOutputStream();
			stream.write(param.getBytes());
			stream.flush();
			stream.close();

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				runnable.run(connection);
			}
		} catch (IOException e) { // | ProtocolException
			e.printStackTrace();
			//TODO:
		}

		return t;
	}

	public URL toURL() throws MalformedURLException {
		return new URL(url);
	}

	public void setURL(String url) {
		this.url = url;
	}

	public T getValue() {
		return t;
	}

	public void setValue(T t) {
		this.t = t;
	}
}
