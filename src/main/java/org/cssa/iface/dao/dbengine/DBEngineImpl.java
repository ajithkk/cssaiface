package org.cssa.iface.dao.dbengine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.cssa.iface.exception.IfaceException;

/**
 * 
 * @author Ajith k k
 * @since 12/12/2011
 */

public class DBEngineImpl {

	private Connection con = null;
	private Statement smt = null;
	private ResultSet res = null;

	private ConnectionManager connectionManager;

	private static DBEngineImpl dbEngineImpl = null;

	private DBEngineImpl() {
		// getConnection();
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		connectionManager = ConnectionManager.getInstance();
		return connectionManager.getConnection();

	}

	public static DBEngineImpl getInstance() {
		if (null == dbEngineImpl) {
			synchronized (DBEngineImpl.class) {
				if (null == dbEngineImpl) {
					dbEngineImpl = new DBEngineImpl();
				}
			}

		}
		return dbEngineImpl;
	}
	
	public ResultSet executeQuery(String query) throws IfaceException {
		res = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			throw new IfaceException("Driver is not fount in connection"
					+ e1.getStackTrace());

		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new IfaceException("Sql exception in connection"
					+ e1.getStackTrace());
		}
		try {
			smt = con.createStatement();
			res = smt.executeQuery(query);
		} catch (SQLException e) {
			rollback(con);
			e.printStackTrace();
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
		} finally {
			ConnectionManager connectionManager = ConnectionManager
					.getInstance();
			connectionManager.closeConnection(con);
			connectionManager.closeStatement(smt);
		}
		return res;

	}

	public int executeUpdate(String query) throws IfaceException {
		int returnId = -1;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e) {
			throw new IfaceException("Driver is not fount in connection"
					+ e.getStackTrace());
		} catch (SQLException e) {
			throw new IfaceException("Sql exception in connection"
					+ e.getStackTrace());
		}

		try {
			smt = con.createStatement();
		} catch (SQLException e1) {
			throw new IfaceException("Sql exception in connection creation"
					+ e1.getStackTrace());
		}
		try {
			returnId = smt.executeUpdate(query);
		} catch (SQLException e) {
			rollback(con);
			e.printStackTrace();
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
		} finally {

			ConnectionManager connectionManager = ConnectionManager
					.getInstance();
			connectionManager.closeConnection(con);
			connectionManager.closeStatement(smt);
		}
		return returnId;

	}
	
	@Deprecated
	public PreparedStatement getPreparedStatement(String query) throws IfaceException {
		PreparedStatement statement = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
		} catch (ClassNotFoundException e1) {
			throw new IfaceException("Driver is not fount in connection"
					+ e1.getStackTrace());

		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new IfaceException("Sql exception in connection"
					+ e1.getStackTrace());
		}
		try {
			statement = con.prepareStatement(query);
		} catch (SQLException e) {
			throw new IfaceException("Statement Creation exception" + e.getStackTrace());
			
		}finally {

			ConnectionManager connectionManager = ConnectionManager
					.getInstance();
			connectionManager.closeConnection(con);
			//connectionManager.closeStatement(smt);
		}
		return statement;
	}
	
	public ResultSet executeQuery(Map<Integer, Object> parameterMap, String sqlCommand) throws IfaceException {
		res = null;
		PreparedStatement statement = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e) {
			throw new IfaceException("Driver is not fount in connection"
					+ e.getStackTrace());
		} catch (SQLException e) {
			throw new IfaceException("Sql exception in connection"
					+ e.getStackTrace());
		}
		try {
			statement = con.prepareStatement(sqlCommand);
			/*Set<Map.Entry<Integer, Object>> parameterSet = parameterMap.entrySet();
			for(Map.Entry<Integer, Object> set : parameterSet ) {
				if(set.getValue().getClass().equals(Integer.TYPE)) {
					statement.setInt(set.getKey(), ((Integer) set.getValue()).intValue());
				}else if (set.getValue().getClass().equals(Float.TYPE)) {
					statement.setFloat(set.getKey(), ((Float) set.getValue()).floatValue());
				}else if (set.getValue().getClass().equals(Double.TYPE)) {
					statement.setDouble(set.getKey(), ((Double) set.getValue()).doubleValue());
				}else if (set.getValue().getClass().equals(Boolean.TYPE)) {
					statement.setBoolean(set.getKey(), ((Boolean) set.getValue()).booleanValue());
				}else if( set.getValue().getClass().equals(Character.TYPE)) {
					statement.setString(set.getKey(), (String) set.getValue());
				}else if(set.getValue().getClass().equals(String.class)) {
					statement.setString(set.getKey(), (String) set.getValue());
				}
			}*/
			con.setAutoCommit(false);
			res = setPreparedStatement(statement, parameterMap).executeQuery();
			commit(con);
		} catch (SQLException e) {
			rollback(con);
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
			
		}finally {
			ConnectionManager connectionManager = ConnectionManager
					.getInstance();
			connectionManager.closeConnection(con);
			connectionManager.closeStatement(statement);
		}
		
		return res;
	}
	
	public int executeUpdate( Map<Integer, Object> parameterMap, String sqlCommand) throws IfaceException {
		
		int returnId = -1;
		PreparedStatement statement = null;
		try {
			con =getConnection();
		} catch (ClassNotFoundException e) {
			throw new IfaceException("Driver is not fount in connection"
					+ e.getStackTrace());
		} catch (SQLException e) {
			throw new IfaceException("Sql exception in connection"
					+ e.getStackTrace());
		}
		try {
			statement = con.prepareStatement(sqlCommand);
			con.setAutoCommit(false);
			/*Set<Map.Entry<Integer, Object>> parameterSet = parameterMap.entrySet();
			for(Map.Entry<Integer, Object> set : parameterSet ) {
				if(set.getValue().getClass().equals(Integer.TYPE)) {
					statement.setInt(set.getKey(), ((Integer) set.getValue()).intValue());
				}else if (set.getValue().getClass().equals(Float.TYPE)) {
					statement.setFloat(set.getKey(), ((Float) set.getValue()).floatValue());
				}else if (set.getValue().getClass().equals(Double.TYPE)) {
					statement.setDouble(set.getKey(), ((Double) set.getValue()).doubleValue());
				}else if (set.getValue().getClass().equals(Boolean.TYPE)) {
					statement.setBoolean(set.getKey(), ((Boolean) set.getValue()).booleanValue());
				}else if( set.getValue().getClass().equals(Character.TYPE)) {
					statement.setString(set.getKey(), (String) set.getValue());
				}else if(set.getValue().getClass().equals(String.class)) {
					statement.setString(set.getKey(), (String) set.getValue());
				}
			}*/
			returnId = setPreparedStatement(statement, parameterMap).executeUpdate();
			commit(con);
		} catch (SQLException e) {
			rollback(con);
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
			
		}finally {
			ConnectionManager connectionManager = ConnectionManager
					.getInstance();
			connectionManager.closeConnection(con);
			connectionManager.closeStatement(statement);
		}
		return returnId;
	}
	
	public int[] executeBatch(List<Map<Integer, Object>> batchParameterList, String sqlCommand) throws IfaceException {
		int returnId[] = null;
		try {
			con =getConnection();
		} catch (ClassNotFoundException e) {
			throw new IfaceException("Driver is not fount in connection"
					+ e.getStackTrace());
		} catch (SQLException e) {
			throw new IfaceException("Sql exception in connection"
					+ e.getStackTrace());
		}
		try {
			//statement = con.prepareStatement(query);
			con.setAutoCommit(false);
			//returnId = statement.executeBatch();
			commit(con);
		} catch (SQLException e) {
			rollback(con);
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
			
		}finally {

			ConnectionManager connectionManager = ConnectionManager
					.getInstance();
			connectionManager.closeConnection(con);
			//connectionManager.closeStatement(statement);
		}
		return returnId; 
	}
	
	private PreparedStatement setPreparedStatement( PreparedStatement statement, Map<Integer, Object> parameterMap) throws IfaceException {
		try{
		Set<Map.Entry<Integer, Object>> parameterSet = parameterMap.entrySet();
		for(Map.Entry<Integer, Object> set : parameterSet ) {
			if(set.getValue().getClass().equals(Integer.TYPE)) {
				statement.setInt(set.getKey(), ((Integer) set.getValue()).intValue());
			}else if (set.getValue().getClass().equals(Float.TYPE)) {
				statement.setFloat(set.getKey(), ((Float) set.getValue()).floatValue());
			}else if (set.getValue().getClass().equals(Double.TYPE)) {
				statement.setDouble(set.getKey(), ((Double) set.getValue()).doubleValue());
			}else if (set.getValue().getClass().equals(Boolean.TYPE)) {
				statement.setBoolean(set.getKey(), ((Boolean) set.getValue()).booleanValue());
			}else if( set.getValue().getClass().equals(Character.TYPE)) {
				statement.setString(set.getKey(), (String) set.getValue());
			}else if(set.getValue().getClass().equals(String.class)) {
				statement.setString(set.getKey(), (String) set.getValue());
			}
		}
		}catch (Exception e) {
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
		}
		return statement;
		
	}
	

	public void closeResultSet(ResultSet res) throws IfaceException {
		if (null != res) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeStatement(Statement smt) throws IfaceException {
		try {
			if (null != smt && !smt.isClosed()) {
				smt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closePreparedStatement(PreparedStatement smt) throws IfaceException{
		try {
			if (null != smt && !smt.isClosed()) {
				smt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void commit(Connection con) throws IfaceException{
		try {
			if(con != null &&!con.isClosed()) {
				con.commit();
				ConnectionManager.getInstance().closeConnection(con);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rollback(Connection con) throws IfaceException {
		try {
			if(null != con && !con.isClosed()) {
				con.rollback();
				ConnectionManager.getInstance().closeConnection(con);
			} 
		} catch (Exception e) {
			throw new IfaceException(e);
		}
	}

}
