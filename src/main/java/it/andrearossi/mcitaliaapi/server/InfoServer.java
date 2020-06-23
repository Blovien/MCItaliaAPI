package it.andrearossi.mcitaliaapi.server;

import com.google.gson.annotations.SerializedName;
import it.andrearossi.mcitaliaapi.utils.html.APIObject;

import java.util.Map;

/**
 *
 */
public class InfoServer implements APIObject {

	// Serialized Variables

	static final String SERVER_ID_FIELD = "serverid";
	static final String VOTES_TODAY_FIELD = "votes_today";
	static final String VERSION_STRING_FIELD = "version_string";
	static final String MAX_PLAYERS_FIELD = "max_players";

	private final String status;

	private final short id;

	@SerializedName(SERVER_ID_FIELD)
	private final String serverId;

	private final String title;

	private final String address;

	private final int position;

	private final boolean hidden;

	private final int votes;

	@SerializedName(VOTES_TODAY_FIELD)
	private final int votesToday;

	private final String description;

	@SerializedName(VERSION_STRING_FIELD)
	private final String versionString;

	private final String[] versions;

	private final boolean online;

	private final int players;

	@SerializedName(MAX_PLAYERS_FIELD)
	private final int maxPlayers;

	private final int slot;

	private final Map<String, StaffUser[]> staff;

	private final String[] categories;

	/**
	 * Object representing a Server in the server list of Minecraft Italia
	 *
	 */
	public InfoServer(
			String status,
			short id,
			String serverId,
			String title,
			String address,
			int position,
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
			Map<String, StaffUser[]> staff,
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

	public short getId() {
		return id;
	}

	public int getPlayers() {
		return players;
	}

	public int getPosition() {
		return position;
	}

	public int getSlot() {
		return slot;
	}

	public int getVotes() {
		return votes;
	}

	public Map<String, StaffUser[]> getStaff() {
		return staff;
	}

	public String getAddress() {
		return address;
	}

	public String getDescription() {
		return description;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public String getServerId() {
		return serverId;
	}

	public String getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}

	public String getVersionString() {
		return versionString;
	}

	public int getVotesToday() {
		return votesToday;
	}

	public String[] getCategories() {
		return categories;
	}

	public String[] getVersions() {
		return versions;
	}

	public boolean isHidden() {
		return hidden;
	}

	public boolean isOnline() {
		return online;
	}
}
