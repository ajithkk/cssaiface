package org.cssa.iface.dao.dbengine;

/**
 * 
 * @author Krishna Prasad
 * @since 12/12/2011
 */

public class DriverManager {
	
	String server;
	String driver;
	String database;
	String username;
	String password;
	public DriverManager(String server, String driver, String database,
			String username, String password) {
		super();
		this.server = server;
		this.driver = driver;
		this.database = database;
		this.username = username;
		this.password = password;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
