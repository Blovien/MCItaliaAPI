import it.andrearossi.mcitaliaapi.MCItaliaAPI;
import it.andrearossi.mcitaliaapi.server.InfoServer;
import it.andrearossi.mcitaliaapi.server.StaffUser;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ServerJsonSerializationTest {

	public static void main(String[] args) {
		HttpConnectionTest.connectionDefault();
		HttpConnectionTest.connectionJson();
		serializeServer();
		deserializeServer();
	}

	@Test
	public static void serializeServer() {
		Map<String, StaffUser[]> map = new HashMap<>();
		map.put("ciao", new StaffUser[]{new StaffUser("ciao", "no"), new StaffUser("salve", "no")});

		InfoServer server = new InfoServer
				("success",
						(short) 10,
						"server",
						"test",
						"mc.test.net",
						10,
						false,
						999,
						0,
						"",
						"1.15 a 1.16",
						new String[]{"1.14", "1.15"},
						true,
						999,
						9999,
						-1,
						map,
						new String[]{"creative", "survival"});

		System.out.println(MCItaliaAPI.toJson(server));
	}

	@Test
	public static void deserializeServer() {
		String json = "{\"status\":\"success\",\"id\":0,\"serverid\":\"feargames\",\"title\":\"FearGames Network\",\"address\":\"mc.feargames.it\",\"position\":20,\"hidden\":false,\"votes\":138,\"votes_today\":0,\"description\":\"\",\"version_string\":\"da 1.8 a 1.15\",\"versions\":[\"1.15\",\"1.14\",\"1.13\",\"1.12\",\"1.11\",\"1.10\",\"1.9\",\"1.8\"],\"online\":true,\"players\":244,\"max_players\":0,\"slot\":3000,\"staff\":{\"Founder\":[{\"uuid\":\"361dcfa8a81c4e3bb876152edfae6617\",\"username\":\"_AleMastro_\"}],\"Admin\":[{\"uuid\":\"485957ec732a454587acfc9ccf086cf2\",\"username\":\"sgdc3\"},{\"uuid\":\"52f446a9292e4fb59337871548ad04dc\",\"username\":\"xlsalvolx\"},{\"uuid\":\"e998f4f7c07c4ad087fb9ae802e0a4f5\",\"username\":\"SognoNero\"},{\"uuid\":\"af07904ec8f949ccb37ed6d3166bc08c\",\"username\":\"PioggiaOscura\"},{\"uuid\":\"4bbae97f582f49ada96b7097ecf393f1\",\"username\":\"WolfNoe98\"}]},\"categories\":[\"factions\",\"minigames\",\"pixelmon\",\"prison\",\"skygames\"]}";

		InfoServer server = MCItaliaAPI.fromJson(json, InfoServer.class);

		System.out.println(server.toString());
	}
}
