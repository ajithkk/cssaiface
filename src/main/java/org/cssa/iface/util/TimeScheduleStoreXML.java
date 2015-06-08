/**
 * 
 */
package org.cssa.iface.util;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.cssa.iface.bo.TimeScheduleStore;

/**
 * @author ajith
 *
 */
public class TimeScheduleStoreXML {
	private static final Logger log = Util.getLogger(TimeScheduleStoreXML.class);
	private static final String TIME_SCHEDULE_STORE_XML = "interface_date.xml";
	
	private TimeScheduleStore timeScheduleStore;
	private Map<String, String> timeScheduleMap;
	/**
	 * 
	 */
	public TimeScheduleStoreXML() {
		super();
		init();
	}
	private void init() {
		try{
			timeScheduleMap = new HashMap<String, String>();
			JAXBContext context = JAXBContext.newInstance(TimeScheduleStore.class);
			Unmarshaller um = context.createUnmarshaller();
			URL url = this.getClass().getClassLoader().getResource(TIME_SCHEDULE_STORE_XML);
			timeScheduleStore = (TimeScheduleStore) um.unmarshal(url);
			
			int size = timeScheduleStore.getTimeScheduleList().size();
			for(int i = 0; i < size; i++) {
				timeScheduleMap.put(timeScheduleStore.getTimeScheduleList().get(i).getScheduleDay(), timeScheduleStore.getTimeScheduleList().get(i).getScheduleDate());
			}
		}catch (JAXBException e) {
			log.error(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the timeScheduleStore
	 */
	public TimeScheduleStore getTimeScheduleStore() {
		return timeScheduleStore;
	}
	/**
	 * @param timeScheduleStore the timeScheduleStore to set
	 */
	public void setTimeScheduleStore(TimeScheduleStore timeScheduleStore) {
		this.timeScheduleStore = timeScheduleStore;
	}
	/**
	 * @return the timeScheduleMap
	 */
	public Map<String, String> getTimeScheduleMap() {
		return timeScheduleMap;
	}
	/**
	 * @param timeScheduleMap the timeScheduleMap to set
	 */
	public void setTimeScheduleMap(Map<String, String> timeScheduleMap) {
		this.timeScheduleMap = timeScheduleMap;
	}
	
	
}
