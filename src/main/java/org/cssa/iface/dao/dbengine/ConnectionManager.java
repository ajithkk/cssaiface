package org.cssa.iface.dao.dbengine;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.cssa.iface.dao.commom.LoadProperties;
import org.cssa.iface.util.Util;
/**
 * 
 * @author Ajith k k
 * @since 12/12/2011
 */

public class ConnectionManager {
	
	public static final Logger log = Util.getLogger(ConnectionManager.class);

	private static volatile ConnectionManager connectionManager = null; 
	
	private String strServer = null;
	private String strDriver = null;
	private String strDatabase = null;
	private String strDbUrl = null;

	private ConnectionManager() {
		loadProperties();
	}

	private void loadProperties() {
		LoadProperties loadProperties = LoadProperties.getInstance();
		strDatabase = loadProperties.getStrDatabase();
		strServer = loadProperties.getStrServer();
		strDriver = loadProperties.getStrDriver();
		strDbUrl = loadProperties.getStrUrl();

	}

	public static ConnectionManager getInstance() {
		if (null == connectionManager) {
			synchronized (ConnectionManager.class) {
				if(null == connectionManager) {
					connectionManager = new ConnectionManager();
				}
			}

		}
		return connectionManager;
	}

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection con = null;
		Class.forName(strDriver);
		con = DriverManager.getConnection(strDbUrl + strServer
				+ File.separator + strDatabase + ";create = true");
		return con;
	}

	public void closeConnection(Connection con) {
		try {
			if (null != con) {
				con.close();
			}
		} catch (Exception e) {
			log.error( e);
			e.printStackTrace();
		}
	}

	public void closeStatement(Statement smt) {
		try {
			if (null != smt) {
				smt.close();
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void closeResultSet(ResultSet res) {
		try {
			if (null != res) {
				res.close();
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
	}

}
