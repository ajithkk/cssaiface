package org.cssa.iface.dao.commom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.cssa.iface.infrastructure.CSSAConstants;


/**
 * 
 * @author Ajith KK
 * @since 12/12/2011
 *
 */

public class LoadProperties {
	
	private static LoadProperties loadProperties = null;
	
	private String strServer = null;
	private String strDriver = null;
	private String strDatabase = null;
	private String strUsername = null;
	private String strPassword = null;
	private String strUrl = null;
	
	
	/**
	 * @return the strUrl
	 */
	public String getStrUrl() {
		return strUrl;
	}

	/**
	 * @param strUrl the strUrl to set
	 */
	public void setStrUrl(String strUrl) {
		this.strUrl = strUrl;
	}

	
	public String getStrServer() {
		return  strServer;
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
		
		Properties properties = new Properties(System.getProperties());
		try{
			String configFilePath = System.getProperty("user.home") +"\\" +CSSAConstants.CONFIG_XML_FILE;
			System.out.println(configFilePath);
			FileInputStream is =  new FileInputStream(configFilePath);
			if(null != is) {
		    	properties.loadFromXML(is);
		        for (Object s : properties.keySet()) {
		            if (DBConstants.DB_SERVER.equalsIgnoreCase((String) s)) {
		            	strServer = properties.getProperty((String)s);
		            }
		            else if (DBConstants.DB_DRIVER.equalsIgnoreCase((String) s)) {
		            	strDriver = properties.getProperty((String)s);
		            }
		            else if(DBConstants.DB_URL.equalsIgnoreCase((String) s)) {
		            	strUrl = properties.getProperty((String)s);
		            }
		            else if(DBConstants.DATA_BASE.equalsIgnoreCase((String)s)) {
		            	strDatabase = properties.getProperty((String)s);
		            } 
		            else if(DBConstants.DB_USERNAME.equalsIgnoreCase((String)s)) {
		            	strUsername = properties.getProperty((String)s);
			        } 
		            else if(DBConstants.DB_PASSWORD.equalsIgnoreCase((String)s)) {
						strPassword = properties.getProperty((String)s);
			        }
		        }
			}
		}catch ( FileNotFoundException fileNotFoundException) {
			try {
				ClassLoader loader = this.getClass().getClassLoader();
				URL  iconUrl = loader.getResource("datebase");
				
			    iconUrl = loader.getResource(CSSAConstants.CONFIG_PROPERTIES_FILE);
				
				properties.load(iconUrl.openStream());
				
				strServer = System.getProperty("user.home")+ "\\" +properties.getProperty(DBConstants.DB_SERVER);
				strDriver = properties.getProperty(DBConstants.DB_DRIVER);
				strUrl = properties.getProperty(DBConstants.DB_URL);
				strDatabase = properties.getProperty(DBConstants.DATA_BASE);
				strUsername = properties.getProperty(DBConstants.DB_USERNAME);
				strPassword = properties.getProperty(DBConstants.DB_PASSWORD);
			}catch (Exception e) {
				e.printStackTrace();
			}
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
