import com.google.gson.JsonObject;
import it.andrearossi.mcitaliaapi.requests.connection.HttpDefaultConnection;
import it.andrearossi.mcitaliaapi.requests.connection.HttpJsonConnection;
import org.junit.jupiter.api.Test;

public class HttpConnectionTest {

	private static final String url = "https://minecraft-italia.it/api/server-info/feargames";

	@Test
	public static void connectionDefault() {
		System.out.println("Connection Default Test: ");
		System.out.println("GET:");

		HttpDefaultConnection connection = new HttpDefaultConnection(url);

		connection.connect();
		System.out.println(connection.get());
	}

	@Test
	public static void connectionJson() {
		System.out.println("Connection Json Test: ");
		System.out.println("GET:");

		HttpJsonConnection connection = new HttpJsonConnection(url);

		connection.connect();
		System.out.println(connection.get());
	}
}
