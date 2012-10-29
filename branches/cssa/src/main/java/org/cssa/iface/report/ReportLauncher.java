package org.cssa.iface.report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.cssa.iface.util.Util;

/**
 * 
 * @author ajith
 *
 */

public class ReportLauncher {
	
	private File fileName;
	private static final Logger log = Util.getLogger(ReportLauncher.class);

	/**
	 * @param fileName
	 */
	public ReportLauncher(File fileName) {
		super();
		this.fileName = fileName;
	}
	/**
	 * method to open report
	 */
	public void open() throws Exception {
		if(!Desktop.isDesktopSupported()) {
			log.error("Desktop is not supported !!!");
			
		} else {
			Desktop desktop = Desktop.getDesktop();
			log.info("Open file"+ fileName.getName());
			if(desktop.isSupported(Desktop.Action.OPEN)) {
				try {
					desktop.open(fileName);
				} catch (IOException e) {
					log.error("Unable to open :"+ fileName, e);
					throw e;
				}
			}
		}
	}
	

}
