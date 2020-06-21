package it.andrearossi.mcitaliaapi.server;

import com.google.gson.annotations.SerializedName;
import it.andrearossi.mcitaliaapi.utils.html.APIObject;

public class ListedServer implements APIObject {

	static final String YAML_CONFIRMED_FIELD = "yaml_confirmed";
	static final String YAML_ERROR_COUNT_FIELD = "yaml_error_count";
	static final String QUERY_ERROR_COUNT_FIELD = "query_error_count";
	static final String FAVICON_URL_FIELD = "favicon_url";
	static final String NAME_LC_FIELD = "name_lc";
	static final String VERSIONS_STRING_FIELD = "versions_string";

	private short id;

	private String name;

	private byte votes;

	private String url;

	private boolean visible;

	private String address;

	private String[] versions;

	private short players;

	private short slots;

	private boolean online;

	private boolean premium;

	private String[] categories;

	private String platform;

	@SerializedName(YAML_CONFIRMED_FIELD)
	private boolean yamlConfirmed;

	@SerializedName(YAML_ERROR_COUNT_FIELD)
	private byte yamlErrorCount;

	@SerializedName(QUERY_ERROR_COUNT_FIELD)
	private byte queryErrorCount;

	private byte position;

	@SerializedName(FAVICON_URL_FIELD)
	private String faviconUrl;

	@SerializedName(NAME_LC_FIELD)
	private String nameLc;

	@SerializedName(VERSIONS_STRING_FIELD)
	private String versionsString;

	public ListedServer(
			short id,
			String name,
			byte votes,
			String url,
			boolean visible,
			String address,
			String[] versions,
			short players,
			short slots,
			boolean online,
			boolean premium,
			String[] categories,
			String platform,
			boolean yamlConfirmed,
			byte yamlErrorCount,
			byte queryErrorCount,
			byte position,
			String faviconUrl,
			String nameLc,
			String versionsString) {
		this.id = id;
		this.name = name;
		this.votes = votes;
		this.url = url;
		this.visible = visible;
		this.address = address;
		this.versions = versions;
		this.players = players;
		this.slots = slots;
		this.online = online;
		this.premium = premium;
		this.categories = categories;
		this.platform = platform;
		this.yamlConfirmed = yamlConfirmed;
		this.yamlErrorCount = yamlErrorCount;
		this.queryErrorCount = queryErrorCount;
		this.position = position;
		this.faviconUrl = faviconUrl;
		this.nameLc = nameLc;
		this.versionsString = versionsString;
	}

	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public byte getVotes() {
		return votes;
	}

	public String getUrl() {
		return url;
	}

	public boolean isVisible() {
		return visible;
	}

	public String getAddress() {
		return address;
	}

	public String[] getVersions() {
		return versions;
	}

	public short getPlayers() {
		return players;
	}

	public short getSlots() {
		return slots;
	}

	public boolean isOnline() {
		return online;
	}

	public boolean isPremium() {
		return premium;
	}

	public String[] getCategories() {
		return categories;
	}

	public String getPlatform() {
		return platform;
	}

	public boolean isYamlConfirmed() {
		return yamlConfirmed;
	}

	public byte getYamlErrorCount() {
		return yamlErrorCount;
	}

	public byte getQueryErrorCount() {
		return queryErrorCount;
	}

	public byte getPosition() {
		return position;
	}

	public String getFaviconUrl() {
		return faviconUrl;
	}

	public String getNameLc() {
		return nameLc;
	}

	public String getVersionsString() {
		return versionsString;
	}
}
