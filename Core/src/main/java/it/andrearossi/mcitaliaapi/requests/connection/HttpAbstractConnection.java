package it.andrearossi.mcitaliaapi.requests.connection;

import it.andrearossi.mcitaliaapi.utils.RunnableVal;

import java.net.HttpURLConnection;

public abstract class HttpAbstractConnection<T> extends HttpConnection<T> {

	public HttpAbstractConnection(String url, String userAgent, String version, T t) {
		super(url, userAgent, version, t);
	}

	public HttpAbstractConnection(String url, T t) {
		super(url, t);
	}

	public T get() {
		return super.getRunnable(runnableAdapter(getValue()));
	}

	public T post(String param) {
		return super.postRunnable(runnableAdapter(getValue()), param);
	}

	public abstract RunnableVal<HttpURLConnection, T> runnableAdapter(T t);

}
