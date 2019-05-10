package com.ajizan.liferay.sightengine;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import java.util.List;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "sightengine")
@Meta.OCD(id = "com.ajizan.liferay.sightengine.SightEngineServiceConfiguration", localization = "content/Language", name = "liferay-sightengine-configuration-name")
public interface SightEngineServiceConfiguration {

	@Meta.AD(deflt = "0.20", required = false, name="sightengine-threshold", description = "sightengine-threshold-description")
	public float getThreshold();

	@Meta.AD(deflt = "https://api.sightengine.com/1.0/check.json", required = false, name="sightengine-url", description = "sightengine-url-description")
	public String getUrl();

	@Meta.AD(deflt = "1037106387", required = false, name="sightengine-api-user", description = "sightengine-api-user-description")
	public String getApiUser();

	@Meta.AD(deflt = "uuqNqUjXLQuFz9fZ5zc2", required = false, name="sightengine-api-secret", description = "sightengine-api-secret-description")
	public String getApiSecret();

	@Meta.AD(deflt = "nudity,wad,offensive", required = false, cardinality = 3, name="sightengine-models", description = "sightengine-models-description")
	public List<String> getModels();
}
