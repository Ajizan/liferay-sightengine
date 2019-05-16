package com.ajizan.liferay.sightengine.api;


import java.io.File;
import java.io.InputStream;


/**
 * @author aiziki
 */
public interface SightEngineService  {
	
	
	
	public boolean isSafeImage(File file);
	
	public boolean isSafeImage(byte[] file);
	
	public boolean isSafeImage(InputStream file);
	
}
