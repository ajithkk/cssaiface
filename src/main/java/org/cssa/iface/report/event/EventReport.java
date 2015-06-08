/**
 * 
 */
package org.cssa.iface.report.event;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;

import org.cssa.iface.bo.Events;
import org.cssa.iface.bo.TimeSheet;
import org.cssa.iface.report.ReportLauncher;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

/**
 * @author ajith
 *
 */
public class EventReport {
	
	private String fileName;
	private List<Events> events;
	private Document document;
	
	/**
	 * @param fileName
	 * @param events
	 */
	public EventReport(String fileName, List<Events> events) {
		this.fileName = fileName;
		this.events = events;
	}
	
	private void addMetaData() {
		document.addTitle("Student Register Number");
		document.addAuthor(System.getProperty("user.name"));
		document.addCreationDate();
		document.addCreator(System.getProperty("user.name"));
		document.addKeywords("Java,Itext,pdf");
	}
	
	private void addHeader() {
		Paragraph header = new Paragraph();
		header.setAlignment(Element.ALIGN_CENTER);
		addEmptyLine(header, 1);
		header.add(new Paragraph( "INTERFACE "+ Calendar.getInstance().get(Calendar.YEAR) , new Font(FontFamily.HELVETICA, Font.DEFAULTSIZE, Font.BOLD)));
		Chunk linebreak = new Chunk(new LineSeparator(2f, 100f, BaseColor.BLACK, Element.ALIGN_LEFT, -1));
		try {
			document.add(header);
			document.add(linebreak);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addTitle() {
		
		Paragraph header = new Paragraph();
		header.setAlignment(Element.ALIGN_CENTER);
		addEmptyLine(header, 1);
		header.add(new Paragraph("Event Report", new Font(FontFamily.HELVETICA, Font.DEFAULTSIZE, Font.BOLD)));
		addEmptyLine(header, 1);
		try {
			document.add(header);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	private void addTable () {
		
		PdfPTable dataTable  = new PdfPTable(5);
		int headerwidths[] = { 5, 12, 10, 10, 8};
		try {
			dataTable.setWidthPercentage(288 / 2.75f);
			dataTable.setWidths(headerwidths);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PdfPCell cell1 = new PdfPCell( new Phrase("Sno"));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell1);
		
		cell1 = new PdfPCell( new Phrase("Event Name"));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell1);
		
		cell1 = new PdfPCell( new Phrase("Event Id"));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		dataTable.addCell(cell1);
		
		cell1 = new PdfPCell( new Phrase("#Participant"));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		dataTable.addCell(cell1);
		
		cell1 = new PdfPCell( new Phrase("Points"));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		dataTable.addCell(cell1);
		int i = 1;
		for(Events event: events) {
			dataTable.addCell(""+(i++));
			dataTable.addCell(event.getEventName());
			dataTable.addCell(event.getEventId());
			dataTable.addCell(""+event.getMaxNoOfParticipants());
			dataTable.addCell(""+event.getPoints());
			
		}
		try {
			document.add(dataTable);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void createReport() throws FileNotFoundException, DocumentException {
		document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(fileName));
		document.open();
		addMetaData();
		addHeader();
		addTitle();
		addTable();
		document.close();
		ReportLauncher launcher = new ReportLauncher(new File(fileName));
		try {
			launcher.open();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addEmptyLine(Paragraph paragraph, int number) {
		for ( int i = 0; i < number; i++ ){
			paragraph.add(new Paragraph(""));
		}
	}
	
	

}
