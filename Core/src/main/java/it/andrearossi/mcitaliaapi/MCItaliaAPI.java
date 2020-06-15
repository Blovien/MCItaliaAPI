package it.andrearossi.mcitaliaapi;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import it.andrearossi.mcitaliaapi.exceptions.APIExceptionHandler;
import it.andrearossi.mcitaliaapi.exceptions.APIExceptionManager;
import it.andrearossi.mcitaliaapi.utils.Ignore;

import java.lang.reflect.Modifier;
import java.util.Optional;

public class MCItaliaAPI {

	private static final MCItaliaAPI instance;

	private static boolean STABLE_API = true;

	private static final Gson gson;

	static {
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
	}

	public void setExceptionManager(APIExceptionManager exceptionManager) {
		MCItaliaAPI.exceptionManager = exceptionManager;
	}

	public static MCItaliaAPI getInstance() {
		return instance;
	}

	public static void useUnstableAPI() {
		STABLE_API = false;
	}

	public static Gson getGson() {
		return gson;
	}

	public static APIExceptionHandler getExceptionHandler() {
		return (Optional.ofNullable(exceptionManager).orElseGet(APIExceptionManager::new)).getHandler();
	}
}
