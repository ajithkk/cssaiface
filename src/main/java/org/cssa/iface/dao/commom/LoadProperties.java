package org.cssa.iface.dao.commom;

import java.io.File;
import java.net.URL;
import java.util.Properties;


/**
 * 
 * @author Ajith KK
 * @since 12/12/2011
 *
 */

public class LoadProperties {
	
	
	private String strServer = null;
	private String strDriver = null;
	private String strDatabase = null;
	private String strUsername = null;
	private String strPassword = null;
	
	private static LoadProperties loadProperties = null;
	
	public String getStrServer() {
		return new File("").getAbsolutePath()+ File.separator + strServer;
	}
	
	public String getStrDriver() {
		return strDriver;
	}
	
	public String getStrDatabase() {
		return strDatabase;
	}
	
	/**
	 * @return the strUsername
	 */
	public String getStrUsername() {
		return strUsername;
	}

	/**
	 * @return the strPassword
	 */
	public String getStrPassword() {
		return strPassword;
	}
	
	
	public static LoadProperties getLoadProperties() {
		return loadProperties;
	}
	
	private LoadProperties() {
		loadDBProperties();		
	}
	
	private void loadDBProperties() {
		
		Properties properties = new Properties();
		
		try{
			
			ClassLoader loader = this.getClass().getClassLoader();
			
			URL  iconUrl = loader.getResource("datebase");
			
		    iconUrl = loader.getResource("properties" + File.separator +"CSSA_IFACE.properties");
			
			properties.load(iconUrl.openStream());
			
			strServer = properties.getProperty(DBConstants.DB_SERVER);
			strDriver = properties.getProperty(DBConstants.DB_DRIVER);
			strDatabase = properties.getProperty(DBConstants.DATA_BASE);
			strUsername = properties.getProperty(DBConstants.DB_USERNAME);
			strPassword = properties.getProperty(DBConstants.DB_PASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static LoadProperties getInstance() {
		
		if(null == loadProperties) {
			synchronized (LoadProperties.class) {
				if(null == loadProperties){
					loadProperties = new LoadProperties();
				}else {
					return loadProperties;
				}
				
			}	
		}
		return loadProperties;
	}
	public static void main(String[] args) {
		LoadProperties properties = LoadProperties.getInstance();
		System.out.print(properties.getStrServer());
	}

}
