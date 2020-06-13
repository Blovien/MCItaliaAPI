import com.google.gson.Gson;
import it.andrearossi.mcitaliaapi.server.Server;
import it.andrearossi.mcitaliaapi.server.User;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ServerSerializationTest {

	public static void main(String[] args) {
		serialize();
	}

	@Test
	public static void serialize() {
		Map<String, User[]> map = new HashMap<>();
		map.put("ciao", new User[]{new User("ciao", "no"), new User("salve", "no")});

		Server server = new Server(
				"success",
				0,
				"feargames",
				"FearGames Network",
				"mc.feargames.it",
				19,
				false
				, 134,
				0,
				"",
				"da 1.8 a 1.15",
				new String[]{"1.15","1.14","1.13","1.12","1.11","1.10","1.9","1.8"},
				true,
				588,
				0,
				3000,
				map,
				new String[]{"factions","minigames","pixelmon","prison","skygames"});

		System.out.println(new Gson().toJson(server));
	}
}
