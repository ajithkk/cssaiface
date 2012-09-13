package org.cssa.iface.bo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author ajith
 *
 */

@XmlRootElement( name ="cssa", namespace = " org.cssa.iface.bo" )
public class EventStageStore {

  @XmlElement(name = "eventStage")
  private ArrayList<EventStage> stageList;

  public void setEventStageList(ArrayList<EventStage> stageList) {
    this.stageList = stageList;
  }

  public ArrayList<EventStage> getStageList() {
    return stageList;
  }

} 