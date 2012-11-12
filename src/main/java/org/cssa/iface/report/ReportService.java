/**
 * 
 */
package org.cssa.iface.report;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

/**
 * @author ajith
 *
 */
public interface ReportService {
	public void addMetaData();
	public void addHeader();
	public void addTitle();
	public void addTable();
	public void createReport() throws FileNotFoundException, DocumentException ;

}
