package it.andrearossi.mcitaliaapi.server;

import com.google.gson.annotations.SerializedName;
import it.andrearossi.mcitaliaapi.APIObject;

import java.util.Map;

public class Server implements APIObject {

	static final String SERVER_ID = "server_id";
	static final String VOTES_TODAY = "votes_today";
	static final String VERSION_STRING = "version_string";
	static final String MAX_PLAYERS = "max_players";

	private final String status;

	private final int id;

	@SerializedName(SERVER_ID)
	private final String serverId;

	private final String title;

	private final String address;

	private final int position; // int?

	private final boolean hidden;

	private final int votes;

	@SerializedName(VOTES_TODAY)
	private final int votesToday;

	private final String description;

	@SerializedName(VERSION_STRING)
	private final String versionString;

	private final String[] versions;

	private final boolean online;

	private final int players;

	@SerializedName(MAX_PLAYERS)
	private final int maxPlayers;

	private final int slot;

	private final Map<String, User[]> staff;

	private final String[] categories;


	public Server(
			String status,
			int id,
			String serverId,
			String title,
			String address, int position,
			boolean hidden,
			int votes,
			int votesToday,
			String description,
			String versionString,
			String[] versions,
			boolean online,
			int players,
			int maxPlayers,
			int slot,
			Map<String, User[]> staff,
			String[] categories
	) {
		this.status = status;
		this.id = id;
		this.serverId = serverId;
		this.title = title;
		this.address = address;
		this.position = position;
		this.hidden = hidden;
		this.votes = votes;
		this.votesToday = votesToday;
		this.description = description;
		this.versionString = versionString;
		this.versions = versions;
		this.online = online;
		this.players = players;
		this.maxPlayers = maxPlayers;
		this.slot = slot;
		this.staff = staff;
		this.categories = categories;
	}
}
