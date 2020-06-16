package it.andrearossi.mcitaliaapi.server;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import it.andrearossi.mcitaliaapi.APIObject;
import it.andrearossi.mcitaliaapi.utils.Costants;
import it.andrearossi.mcitaliaapi.utils.Ignore;

import java.util.Map;
import java.util.Optional;

/**
 *
 */
public class Server implements APIObject {

	// Ignored variables in Serialization

	@Ignore
	private String faviconUrl;

	@Ignore
	private ServerPlatform platform;

	// Serialized Variables

	static final String SERVER_ID_FIELD = "serverid";
	static final String VOTES_TODAY_FIELD = "votes_today";
	static final String VERSION_STRING_FIELD = "version_string";
	static final String MAX_PLAYERS_FIELD = "max_players";

	private final String status;

	private final int id;

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

	private final Map<String, User[]> staff;

	private final String[] categories;

	/**
	 * Object representing a Server in the server list of Minecraft Italia
	 *
	 * @param status
	 * @param id
	 * @param serverId
	 * @param title
	 * @param address
	 * @param position
	 * @param hidden
	 * @param votes
	 * @param votesToday
	 * @param description
	 * @param versionString
	 * @param versions
	 * @param online
	 * @param players
	 * @param maxPlayers
	 * @param slot
	 * @param staff
	 * @param categories
	 */
	public Server(
			String faviconUrl,
			String status,
			int id,
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
			Map<String, User[]> staff,
			String[] categories
	) {
		this.faviconUrl = Optional.ofNullable(faviconUrl).orElse("");
		this.platform = ServerPlatform.JAVA;
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

	public Server (
			String status,
			int id,
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
			Map<String, User[]> staff,
			String[] categories
	) {
		this(null, status, id, serverId, title, address, position, hidden, votes, votesToday, description, versionString, versions, online, players, maxPlayers, slot, staff, categories);
	}

	public int getId() {
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

	public Map<String, User[]> getStaff() {
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

	public String getFaviconUrl() {
		return Optional.ofNullable(faviconUrl).orElse(Costants.FAVICON_URL + serverId);
	}

	public ServerPlatform getPlatform() {
		return platform;
	}
}
