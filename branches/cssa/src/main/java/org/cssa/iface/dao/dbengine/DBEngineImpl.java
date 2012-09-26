package org.cssa.iface.dao.dbengine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.cssa.iface.exception.IfaceException;
import org.cssa.iface.util.Util;

/**
 * 
 * @author Ajith k k
 * @since 12/12/2011
 */

public class DBEngineImpl {
	
	private static final Logger log = Util.getLogger(DBEngineImpl.class);

	private Connection con = null;
	private Statement smt = null;
	private ResultSet res = null;

	private ConnectionManager connectionManager;

	private static DBEngineImpl dbEngineImpl = null;

	public  DBEngineImpl() {
		connectionManager = ConnectionManager.getInstance();
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		return connectionManager.getConnection();

	}
	public static DBEngineImpl getInstance() {
		if (null == dbEngineImpl) {
			dbEngineImpl = new DBEngineImpl();
		}
		return dbEngineImpl;
	}
	
	public ResultSet executeQuery(String query) throws IfaceException {
		res = null;
		try {
			log.info("Query" +query);
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			log.error("Exception"+ e1);
			throw new IfaceException("Driver is not fount in connection"
					+ e1.getStackTrace());

		} catch (SQLException e1) {
			log.error("Exception"+ e1);
			e1.printStackTrace();
			throw new IfaceException("Sql exception in connection"
					+ e1.getStackTrace());
		}
		try {
			smt = con.createStatement();
			res = smt.executeQuery(query);
			
			con.setAutoCommit(true);
		} catch (SQLException e) {
			rollback(con);
			e.printStackTrace();
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
		} finally {
			//connectionManager.closeConnection(con);
			//connectionManager.closeStatement(smt);
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
			log.error("Exception"+ e);
			e.printStackTrace();
			throw new IfaceException("Sql exception in connection"
					+ e.getStackTrace());
		}

		try {
			smt = con.createStatement();
		} catch (SQLException e1) {
			log.error("Exception"+ e1);
			throw new IfaceException("Sql exception in connection creation"
					+ e1.getStackTrace());
		}
		try {
			returnId = smt.executeUpdate(query);
		} catch (SQLException e) {
			rollback(con);
			log.error("Exception"+ e);
			e.printStackTrace();
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
		} finally {
			
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
			log.error("Exception"+ e1);
			throw new IfaceException("Driver is not fount in connection"
					+ e1.getStackTrace());

		} catch (SQLException e1) {
			log.error("Exception"+ e1);
			e1.printStackTrace();
			throw new IfaceException("Sql exception in connection"
					+ e1.getStackTrace());
		}
		try {
			statement = con.prepareStatement(query);
		} catch (SQLException e) {
			log.error("Exception"+ e);
			throw new IfaceException("Statement Creation exception" + e.getStackTrace());
			
		}finally {
			//closePreparedStatement(statement);
			//connectionManager.closeConnection(con);
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
			log.error("Exception"+ e);
			throw new IfaceException("Driver is not fount in connection"
					+ e.getStackTrace());
		} catch (SQLException e) {
			log.error("Exception"+ e);
			throw new IfaceException("Sql exception in connection"
					+ e.getStackTrace());
		}
		try {
			log.info(sqlCommand);
			statement = con.prepareStatement(sqlCommand);
			con.setAutoCommit(false);
			res = setPreparedStatement(statement, parameterMap).executeQuery();
			commit(con);
			con.setAutoCommit(true);
		} catch (SQLException e) {
			rollback(con);
			log.error("Exception"+  e);
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
			
		}finally {
			//connectionManager.closeConnection(con);
			//connectionManager.closeStatement(statement);
			//closePreparedStatement(statement);
		}
		
		return res;
	}
	
	public int executeUpdate( Map<Integer, Object> parameterMap, String sqlCommand) throws IfaceException {
		
		int returnId = -1;
		PreparedStatement statement = null;
		try {
			con =getConnection();
		} catch (ClassNotFoundException e) {
			log.error("Exception"+ e);
			throw new IfaceException("Driver is not fount in connection"
					+ e.getStackTrace());
		} catch (SQLException e) {
			log.error("Exception"+ e);
			throw new IfaceException("Sql exception in connection"
					+ e.getStackTrace());
		}
		try {
			statement = con.prepareStatement(sqlCommand);
			con.setAutoCommit(false);
			returnId = setPreparedStatement(statement, parameterMap).executeUpdate();
			commit(con);
		} catch (SQLException e) {
			rollback(con);
			log.error("Exception"+ e);
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
			
		}finally {
			connectionManager.closeConnection(con);
			connectionManager.closeStatement(statement);
			closePreparedStatement(statement);
		}
		return returnId;
	}
	
	public int[] executeBatch(List<Map<Integer, Object>> batchParameterList, String sqlCommand) throws IfaceException {
		int returnId[] = null;
		PreparedStatement statement = null;
		try {
			con =getConnection();
		} catch (ClassNotFoundException e) {
			log.error("Exception"+ e);
			throw new IfaceException("Driver is not fount in connection"
					+ e.getStackTrace());
		} catch (SQLException e) {
			throw new IfaceException("Sql exception in connection"
					+ e.getStackTrace());
		}
		try {
			statement = con.prepareStatement(sqlCommand);
			con.setAutoCommit(false);
			returnId = setBatchPreparedStatement(statement, batchParameterList).executeBatch();
			commit(con);
		} catch (SQLException e) {
			rollback(con);
			log.error("Exception"+ e);
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
			
		}finally {
			connectionManager.closeConnection(con);
			connectionManager.closeStatement(statement);
			closePreparedStatement(statement);
		}
		return returnId; 
	}
	
	private PreparedStatement setPreparedStatement( PreparedStatement statement, Map<Integer, Object> parameterMap) throws IfaceException {
		try{
		Set<Map.Entry<Integer, Object>> parameterSet = parameterMap.entrySet();
		for(Map.Entry<Integer, Object> set : parameterSet ) {
			if( null != set.getValue()) {
				if(set.getValue().getClass().equals(Integer.class)) {
					statement.setInt(set.getKey(), ((Integer) set.getValue()).intValue());
				}else if (set.getValue().getClass().equals(Float.class)) {
					statement.setFloat(set.getKey(), ((Float) set.getValue()).floatValue());
				}else if (set.getValue().getClass().equals(Double.class)) {
					statement.setDouble(set.getKey(), ((Double) set.getValue()).doubleValue());
				}else if (set.getValue().getClass().equals(Boolean.class)) {
					statement.setBoolean(set.getKey(), ((Boolean) set.getValue()).booleanValue());
				}else if( set.getValue().getClass().equals(Character.class)) {
					statement.setString(set.getKey(), set.getValue().toString());
				}else if(set.getValue().getClass().equals(String.class)) {
					statement.setString(set.getKey(), (String) set.getValue());
				} else if (set.getValue().getClass().equals(Date.class)) {
					statement.setDate(set.getKey(), new java.sql.Date(((Date)set.getValue()).getTime()));
				}
			}
		}
		}catch (Exception e) {
			log.error("Exception"+ e);
			throw new IfaceException("Sql exception in Query execution"
					+ e.getStackTrace());
		}
		return statement;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PreparedStatement setBatchPreparedStatement( PreparedStatement statement, List<Map<Integer, Object>> batchParameterList) throws IfaceException {
		for(Map parameterMap : batchParameterList ) {
			statement = setPreparedStatement(statement, parameterMap);
			try {
				statement.addBatch();
			} catch (SQLException e) {
				log.error("Exception"+ e);
				throw new IfaceException("Sql exception in Query execution"
						+ e.getStackTrace());
			}
		}
		return statement;
		
	}

	public void closeResultSet(ResultSet res) throws IfaceException {
		if (null != res) {
			try {
				res.close();
				closeStatement(smt);
				closeConnection();
			} catch (SQLException e) {
				log.error("Exception"+ e);
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
			log.error("Exception"+ e);
			e.printStackTrace();
		}
	}
	
	public void closePreparedStatement(PreparedStatement smt) throws IfaceException{
		try {
			if (null != smt && !smt.isClosed()) {
				smt.close();
			}
		} catch (Exception e) {
			log.error("Exception"+ e);
			e.printStackTrace();
		}
	}
	
	public void commit(Connection con) throws IfaceException{
		try {
			if(con != null &&!con.isClosed()) {
				con.commit();
				//connectionManager.closeConnection(con);
			}
		}catch (Exception e) {
			log.error("Exception"+ e);
			e.printStackTrace();
		}
	}
	
	public void rollback(Connection con) throws IfaceException {
		try {
			if(null != con && !con.isClosed()) {
				con.rollback();
				connectionManager.closeConnection(con);
			} 
		} catch (Exception e) {
			log.error("Exception"+ e);
			throw new IfaceException(e);
		}
	}
	
	public void closeConnection() throws IfaceException {
		try {
			if(null != con && !con.isClosed()) {
				connectionManager.closeConnection(con);
			} 
		} catch (Exception e) {
			log.error("Exception"+ e);
			throw new IfaceException(e);
		}
		
	}

}
