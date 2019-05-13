package com.ajizan.liferay.sightengine;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import java.util.List;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "sightengine")
@Meta.OCD(id = "com.ajizan.liferay.sightengine.SightEngineServiceConfiguration", localization = "content/Language", name = "liferay-sightengine-configuration-name")
public interface SightEngineServiceConfiguration {

	

	@Meta.AD(deflt = "https://api.sightengine.com/1.0/check.json", required = false, name="sightengine-url", description = "sightengine-url-description")
	public String getUrl();

	@Meta.AD(deflt = "1037106387", required = false, name="sightengine-api-user", description = "sightengine-api-user-description")
	public String getApiUser();

	@Meta.AD(deflt = "uuqNqUjXLQuFz9fZ5zc2", required = false, name="sightengine-api-secret", description = "sightengine-api-secret-description")
	public String getApiSecret();

	@Meta.AD(deflt = "nudity,wad,offensive", required = false, cardinality = 3, name="sightengine-models", description = "sightengine-models-description")
	public List<String> getModels();
	
	@Meta.AD(deflt = "0.20", required = false, name="sightengine-Weapon-threshold", description = "sightengine-weapon-threshold-description")
	public float getWeaponThreshold();
	@Meta.AD(deflt = "0.20", required = false, name="sightengine-Alcohol-threshold", description = "sightengine-Alcohol-threshold-description")
	public float getAlcoholThreshold();
	@Meta.AD(deflt = "0.20", required = false, name="sightengine-Drugs-threshold", description = "sightengine-Drugs-threshold-description")
	public float getDrugsThreshold();
	
	@Meta.AD(deflt = "0.20", required = false, name="sightengine-Offensive-threshold", description = "sightengine-Offensive-threshold-description")
	public float getOffensiveThreshold();
	
	
	@Meta.AD(deflt = "0.20", required = false, name="sightengine-RawNudity-threshold", description = "sightengine-RawNudity-threshold-description")
	public float getRawNudityThreshold();
	@Meta.AD(deflt = "0.20", required = false, name="sightengine-PartialNudity-threshold", description = "sightengine-PartialNudity-threshold-description")
	public float getPartialNudityThreshold();
}
