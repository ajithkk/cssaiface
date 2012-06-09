package org.cssa.iface.dao.dbengine;

import org.cssa.iface.exception.IfaceException;

public class Test {
	public static void main(String[] args) {
		DBEngineImpl dbEngineImpl = DBEngineImpl.getInstance();
		String query = "insert into EVENTS (EVENT_ID, MAX_NO_OF_PARTICIPANTS, EVENT_NAME ) values('event11',3,'cp')";
		try {
		int r	= dbEngineImpl.executeUpdate(query);
		if(r != -1) {
			System.out.print("Sucess");
		}
		} catch (IfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
