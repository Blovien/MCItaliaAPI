import it.andrearossi.mcitaliaapi.requests.connection.HttpDefaultConnection;
import org.junit.jupiter.api.Test;

public class HttpConnectionTest {

	@Test
	public static void connectionDefault() {
		StringBuilder builder = new StringBuilder();
		HttpDefaultConnection connection = new HttpDefaultConnection("https://minecraft-italia.it/api/server-info/feargames", builder);

		connection.connect();
		System.out.println(connection.get());
	}
}
