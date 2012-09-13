package org.cssa.iface.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "eventStage")
@XmlType(propOrder = { "stage", "notation" })
public class EventStage {

	private String stage;
	private String notation;

	/**
	 * @return the stage
	 */

	@XmlElement(name = "stage")
	public String getStage() {
		return stage;
	}

	/**
	 * @param stage
	 *            the stage to set
	 */
	public void setStage(String stage) {
		this.stage = stage;
	}

	/**
	 * @return the notation
	 */
	public String getNotation() {
		return notation;
	}

	/**
	 * @param notation
	 *            the notation to set
	 */
	public void setNotation(String notation) {
		this.notation = notation;
	}

}