package org.cssa.iface.util;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.cssa.iface.bo.EventStageStore;
import org.cssa.iface.dao.dbengine.DBEngineImpl;

/**
 * 
 * @author ajith
 *
 */

public class EventStorageXML {
	private static final Logger log = Util.getLogger(EventStorageXML.class);
	private static final String EVENT_STAGE_XML = "event_stages.xml";

	private EventStageStore eventStageStore;
	private Map<String, String> eventStageMap;

	public EventStorageXML() {
		init();
	}

	private void init()  {
		try {
			eventStageMap = new HashMap<String, String>();
			JAXBContext context = JAXBContext
					.newInstance(EventStageStore.class);
			Unmarshaller um = context.createUnmarshaller();
			URL url = this.getClass().getClassLoader().getResource(EVENT_STAGE_XML);
			eventStageStore = (EventStageStore) um.unmarshal(url);
			int size = eventStageStore.getStageList().size();
			for(int i = 0; i < size; i++) {
				eventStageMap.put(eventStageStore.getStageList().get(i).getNotation(), eventStageStore.getStageList().get(i).getStage());
				
			}
			
		} catch (JAXBException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	/**
	 * @return the eventStageStore
	 */
	public EventStageStore getEventStageStore() {
		return eventStageStore;
	}

	/**
	 * @param eventStageStore
	 *            the eventStageStore to set
	 */
	public void setEventStageStore(EventStageStore eventStageStore) {
		this.eventStageStore = eventStageStore;
	}

	/**
	 * @return the eventStageMap
	 */
	public Map<String, String> getEventStageMap() {
		return eventStageMap;
	}

	/**
	 * @param eventStageMap the eventStageMap to set
	 */
	public void setEventStageMap(Map<String, String> eventStageMap) {
		this.eventStageMap = eventStageMap;
	}
	
}