package it.andrearossi.mcitaliaapi;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import it.andrearossi.mcitaliaapi.exceptions.APIExceptionManager;

import java.lang.reflect.Modifier;

public class MCItaliaAPI {

	private static final MCItaliaAPI instance;

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
						return fieldAttributes.hasModifier(Modifier.STATIC);
					}

					@Override public boolean shouldSkipClass(Class<?> aClass) {
						return false;
					}
				})
				.disableHtmlEscaping();

		gson = builder.create();
	}

	private APIExceptionManager exceptionManager;

	public MCItaliaAPI() {
	}

	public void setExceptionManager(APIExceptionManager exceptionManager) {
		this.exceptionManager = exceptionManager;
	}

	public static MCItaliaAPI getInstance() {
		return instance;
	}

	public static Gson getGson() {
		return gson;
	}

	public APIExceptionManager getExceptionHandler() {
		return exceptionManager == null ? new APIExceptionManager() : exceptionManager;
	}
}
