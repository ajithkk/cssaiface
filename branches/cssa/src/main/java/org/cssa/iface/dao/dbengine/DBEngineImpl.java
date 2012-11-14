package org.cssa.iface.dao.dbengine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	/**
	 * 
	 * @param query
	 * @return
	 * @throws IfaceException
	 */
	public ResultSet executeQuery(String query) throws IfaceException {
		res = null;
		try {
			log.info("Query: " +query);
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			log.error(e1);
			throw new IfaceException(e1);

		} catch (SQLException e1) {
			log.error(e1);
			e1.printStackTrace();
			throw new IfaceException(e1);
		}
		try {
			smt = con.createStatement();
			res = smt.executeQuery(query);
			
			con.setAutoCommit(true);
		} catch (SQLException e) {
			rollback(con);
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
		} finally {
			//connectionManager.closeConnection(con);
			//connectionManager.closeStatement(smt);
		}
		return res;

	}
    
	/**
	 * 
	 * @param query
	 * @return
	 * @throws IfaceException
	 */
	public int executeUpdate(String query) throws IfaceException {
		int returnId = -1;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e) {
			log.error(e);
			throw new IfaceException(e);
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
		}

		try {
			smt = con.createStatement();
		} catch (SQLException e1) {
			log.error(e1);
			e1.printStackTrace();
			throw new IfaceException(e1);
		}
		try {
			log.info(query);
			returnId = smt.executeUpdate(query);
		} catch (SQLException e) {
			rollback(con);
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
		} finally {
			
			connectionManager.closeConnection(con);
			connectionManager.closeStatement(smt);
		}
		return returnId;

	}
	
	/**
	 * 
	 * @param query
	 * @return
	 * @throws IfaceException
	 */
	@Deprecated
	public PreparedStatement getPreparedStatement(String query) throws IfaceException {
		PreparedStatement statement = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
		} catch (ClassNotFoundException e1) {
			log.error("Exception"+ e1);
			throw new IfaceException("Driver is not fount in connection",e1);

		} catch (SQLException e1) {
			log.error( e1);
			e1.printStackTrace();
			throw new IfaceException("Sql exception in connection",e1);
		}
		try {
			statement = con.prepareStatement(query);
		} catch (SQLException e) {
			log.error("Exception"+ e);
			throw new IfaceException("Statement Creation exception" ,e);
			
		}finally {
			//closePreparedStatement(statement);
			//connectionManager.closeConnection(con);
			//connectionManager.closeStatement(smt);
		}
		return statement;
	}
	
	/**
	 * 
	 * @param parameterMap
	 * @param sqlCommand
	 * @return
	 * @throws IfaceException
	 */
	public ResultSet executeQuery(Map<Integer, Object> parameterMap, String sqlCommand) throws IfaceException {
		res = null;
		PreparedStatement statement = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e) {
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
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
			log.error( e);
			e.printStackTrace();
			throw new IfaceException(e);
			
		}finally {
			//connectionManager.closeConnection(con);
			//connectionManager.closeStatement(statement);
			//closePreparedStatement(statement);
		}
		
		return res;
	}
	
	/**
	 * 
	 * @param parameterMap
	 * @param sqlCommand
	 * @return
	 * @throws IfaceException
	 */
	public int executeUpdate( Map<Integer, Object> parameterMap, String sqlCommand) throws IfaceException {
		
		int returnId = -1;
		PreparedStatement statement = null;
		try {
			con =getConnection();
		} catch (ClassNotFoundException e) {
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
		}
		try {
			log.info(sqlCommand);
			statement = con.prepareStatement(sqlCommand);
			con.setAutoCommit(false);
			returnId = setPreparedStatement(statement, parameterMap).executeUpdate();
			commit(con);
		} catch (SQLException e) {
			rollback(con);
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
			
		}finally {
			connectionManager.closeConnection(con);
			connectionManager.closeStatement(statement);
			closePreparedStatement(statement);
		}
		return returnId;
	}
	
	/**
	 * 
	 * @param batchParameterList
	 * @param sqlCommand
	 * @return
	 * @throws IfaceException
	 */
	public int[] executeBatch(List<Map<Integer, Object>> batchParameterList, String sqlCommand) throws IfaceException {
		int returnId[] = null;
		log.info(sqlCommand);
		PreparedStatement statement = null;
		try {
			con =getConnection();
		} catch (ClassNotFoundException e) {
			log.error( e);
			e.printStackTrace();
			throw new IfaceException(e);
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
		}
		try {
			statement = con.prepareStatement(sqlCommand);
			log.info(sqlCommand);
			con.setAutoCommit(false);
			returnId = setBatchPreparedStatement(statement, batchParameterList).executeBatch();
			commit(con);
		} catch (SQLException e) {
			rollback(con);
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
			
		}finally {
			connectionManager.closeConnection(con);
			connectionManager.closeStatement(statement);
			closePreparedStatement(statement);
		}
		return returnId; 
	}
	
	/**
	 * method to execute the script file
	 * @param fileName
	 * @throws IfaceException
	 */
	public void executeScript(String fileName) throws IfaceException {
		try {
			log.info(fileName);
			con = getConnection();
			ScriptRunner runner = new ScriptRunner(con, true, true);
			runner.runScript(new BufferedReader(new FileReader(fileName)));
			
		} catch (FileNotFoundException e) {
			log.error( e);
			e.printStackTrace();
			throw new IfaceException(e);
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
		} catch (ClassNotFoundException e) {
			log.error( e);
			e.printStackTrace();
			throw new IfaceException(e);
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
			throw new IfaceException(e);
		} finally {
			connectionManager.closeConnection(con);
		}
	}
	
	/**
	 * 
	 * @return all table names
	 * @throws IfaceException
	 */
	public List<String> getAllTableNames() throws IfaceException {
		List<String> tableName = new ArrayList<String>();
		ResultSet res = null;
		try {
			con = getConnection();
			DatabaseMetaData databaseMetaData = con.getMetaData();
			res = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});
			while(res.next()) {
				tableName.add(res.getString("TABLE_NAME"));
			}
			
		} catch (ClassNotFoundException e) {
			log.error(e);
			throw new IfaceException(e);
		} catch (SQLException e) {
			log.error( e);
			throw new IfaceException(e);
		} finally {
			closeResultSet(res);
			connectionManager.closeConnection(con);
		}
		
		return tableName;
	}
	
	/**
	 * 
	 * @param statement
	 * @param parameterMap
	 * @return
	 * @throws IfaceException
	 */
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
			log.error(e);
			throw new IfaceException(e);
		}
		return statement;
		
	}
	
	/**
	 * 
	 * @param statement
	 * @param batchParameterList
	 * @return
	 * @throws IfaceException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PreparedStatement setBatchPreparedStatement( PreparedStatement statement, List<Map<Integer, Object>> batchParameterList) throws IfaceException {
		for(Map parameterMap : batchParameterList ) {
			statement = setPreparedStatement(statement, parameterMap);
			try {
				statement.addBatch();
			} catch (SQLException e) {
				log.error(e);
				throw new IfaceException(e);
			}
		}
		return statement;
		
	}

	/**
	 * method to close the result set
	 * @param res
	 * @throws IfaceException
	 */
	public void closeResultSet(ResultSet res) throws IfaceException {
		if (null != res) {
			try {
				res.close();
				closeStatement(smt);
				closeConnection();
			} catch (SQLException e) {
				log.error(e);
				throw new IfaceException(e);
			}
		}
	}
	
	/**
	 * method to close statement
	 * @param smt
	 * @throws IfaceException
	 */
	public void closeStatement(Statement smt) throws IfaceException {
		try {
			if (null != smt && !smt.isClosed()) {
				smt.close();
			}
		} catch (Exception e) {
			log.error(e);
			throw new IfaceException(
					 e);
		}
	}
	
	/**
	 * method to close prepared statement
	 * @param smt
	 * @throws IfaceException
	 */
	public void closePreparedStatement(PreparedStatement smt) throws IfaceException{
		try {
			if (null != smt && !smt.isClosed()) {
				smt.close();
			}
		} catch (Exception e) {
			log.error(e);
			throw new IfaceException(
					e);
		}
	}
	
	/**
	 * method to commit the transaction
	 * @param con
	 * @throws IfaceException
	 */
	public void commit(Connection con) throws IfaceException{
		try {
			if(con != null &&!con.isClosed()) {
				con.commit();
				//connectionManager.closeConnection(con);
			}
		}catch (Exception e) {
			log.error(e);
			throw new IfaceException(
					e);
		}
	}
	
	/**
	 * roll back the transaction
	 * @param con
	 * @throws IfaceException
	 */
	public void rollback(Connection con) throws IfaceException {
		try {
			if(null != con && !con.isClosed()) {
				con.rollback();
				connectionManager.closeConnection(con);
			} 
		} catch (Exception e) {
			log.error( e);
			throw new IfaceException(e);
		}
	}
	
	/**
	 * method to close the connection
	 * @throws IfaceException
	 */
	public void closeConnection() throws IfaceException {
		try {
			if(null != con && !con.isClosed()) {
				connectionManager.closeConnection(con);
			} 
		} catch (Exception e) {
			log.error( e);
			throw new IfaceException(e);
		}
		
	}

}
