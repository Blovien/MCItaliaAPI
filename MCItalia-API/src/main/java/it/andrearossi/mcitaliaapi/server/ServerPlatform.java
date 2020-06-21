package it.andrearossi.mcitaliaapi.server;

public enum ServerPlatform {
	JAVA,
	BEDROCK;

	public String getName() {
		return name().toLowerCase();
	}
}
