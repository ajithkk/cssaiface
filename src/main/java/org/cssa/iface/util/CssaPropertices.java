package org.cssa.iface.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author ajith
 *
 */

public class CssaPropertices {
	
	private static Properties propertices = null;
	private static final String CSSA_PROP_FILE = "/CSSA_IFACE.properties";
	
	private CssaPropertices(){}
	
	public static String getProperty(String key) throws IOException {
		return getProperty(key, null);
	}
	
	public static String getProperty(String key, String defaultValue) throws IOException {
		if(null == propertices) {
			synchronized (CssaPropertices.class) {
				if(null == propertices) {
					propertices = loadProperties();
				}
			}
		}
		return propertices.getProperty(key, defaultValue);
	}
	
	private static Properties loadProperties() throws IOException {
		
		InputStream stream = null;
		try {
			propertices = new Properties();
			stream = new CssaPropertices().getClass().getResourceAsStream(CSSA_PROP_FILE);
			propertices.load(stream);
		} finally {
			try {
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return propertices;
		
	}
	
	public static Properties getPropertyList() throws IOException {
		synchronized (CssaPropertices.class) {
		
			if(null == propertices) {
				propertices = loadProperties();
			}
		}
		return propertices;
	}
	
	
	

}
