package it.andrearossi.mcitaliaapi;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import it.andrearossi.mcitaliaapi.exceptions.APIExceptionHandler;
import it.andrearossi.mcitaliaapi.exceptions.APIExceptionManager;
import it.andrearossi.mcitaliaapi.utils.Ignore;
import it.andrearossi.mcitaliaapi.utils.html.APIObject;

import java.lang.reflect.Modifier;
import java.util.Optional;

public class MCItaliaAPI {

	private static final MCItaliaAPI instance;

	private final boolean cacheSystem;

	private static final Gson gson;

	static {
		// GSON INITIALIZATION

		instance = new MCItaliaAPI();

		GsonBuilder builder = new GsonBuilder()
				.excludeFieldsWithModifiers(Modifier.TRANSIENT)
				.addDeserializationExclusionStrategy(new ExclusionStrategy() {
					@Override public boolean shouldSkipField(FieldAttributes fieldAttributes) {
						return fieldAttributes.hasModifier(Modifier.STATIC)
								&& fieldAttributes.getAnnotation(Expose.class) == null;
					}

					@Override public boolean shouldSkipClass(Class<?> aClass) {
						return false;
					}
				})
				.addSerializationExclusionStrategy(new ExclusionStrategy() {
					@Override public boolean shouldSkipField(FieldAttributes fieldAttributes) {
						return fieldAttributes.hasModifier(Modifier.STATIC) || fieldAttributes.getAnnotation(Ignore.class) != null;
					}

					@Override public boolean shouldSkipClass(Class<?> aClass) {
						return false;
					}
				})
				.disableHtmlEscaping();

		gson = builder.create();
	}

	private static APIExceptionManager exceptionManager;

	public MCItaliaAPI() {
		this(false, null);
	}

	public MCItaliaAPI(boolean cacheSystem) {
		this(cacheSystem, null);
	}

	public MCItaliaAPI(boolean cacheSystem, Long delay) {
		this.cacheSystem = cacheSystem;

		if (cacheSystem)
			new MCItaliaCache().init(delay);
	}

	// SETUP

	public void setExceptionManager(APIExceptionManager exceptionManager) {
		MCItaliaAPI.exceptionManager = exceptionManager;
	}

	public static MCItaliaAPI getInstance() {
		return instance;
	}

	// UTILITY

	public static <T extends APIObject> T fromJson(JsonObject object, Class<T> clazz) {
		return getGson().fromJson(object, clazz);
	}

	public static <T> T fromJson(String object, Class<T> clazz) {
		return getGson().fromJson(object, clazz);
	}

	public static String toJson(Object object) {
		return getGson().toJson(object);
	}

	// GETTERS

	protected static Gson getGson() {
		return gson;
	}

	public static APIExceptionHandler getExceptionHandler() {
		return (Optional.ofNullable(exceptionManager).orElseGet(APIExceptionManager::new)).getHandler();
	}
}
