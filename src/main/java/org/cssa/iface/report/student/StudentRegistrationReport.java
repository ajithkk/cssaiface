package org.cssa.iface.report.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.cssa.iface.bo.StudentDetails;
import org.cssa.iface.report.ReportLauncher;
import org.cssa.iface.report.bo.StudentRegisterDocument;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

/**
 * 
 * @author ajith
 *
 */
public class StudentRegistrationReport {
	
	private String fileName;
	private Document document;
	private StudentRegisterDocument student;
	
	
	
	public StudentRegistrationReport(String fileName, StudentRegisterDocument student) {
		super();
		this.fileName = fileName;
		this.student = student;
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
		header.add(new Paragraph("College Initial Details", new Font(FontFamily.HELVETICA, Font.DEFAULTSIZE, Font.BOLD)));
		addEmptyLine(header, 1);
		Paragraph preface = new Paragraph();
		preface.add(new Paragraph("College Name: "+student.getCollegeName()));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Number of Participants :"+ student.getNumberOfParticipants()));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Phone Number: " + student.getPhoneNumber()));
		addEmptyLine(preface, 1);
		try {
			document.add(header);
			document.add(preface);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	private void addEmptyLine(Paragraph paragraph, int number) {
		for ( int i = 0; i < number; i++ ){
			paragraph.add(new Paragraph(""));
		}
	}
	
	private void addTable () {
		
		PdfPTable dataTable  = new PdfPTable(5);
		
		try {
			dataTable.setWidthPercentage(288 / 2.75f);
			dataTable.setWidths(new int[]{1, 1, 1, 3, 3});
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PdfPCell cell1 = new PdfPCell( new Phrase("Sno"));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell1);
		
		cell1 = new PdfPCell( new Phrase("College id"));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		dataTable.addCell(cell1);
		
		cell1 = new PdfPCell( new Phrase("Student id"));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		dataTable.addCell(cell1);
		
		cell1 = new PdfPCell( new Phrase("Name"));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell1);
		
		
		cell1 = new PdfPCell( new Phrase("Events"));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		dataTable.addCell(cell1);
		int i = 1;
		for(StudentDetails studentDetails: student.getStudentDetails()) {
			dataTable.addCell(""+(i++));
			dataTable.addCell(student.getCollegeId());
			dataTable.addCell(studentDetails.getStudentId());
			dataTable.addCell("");
			dataTable.addCell("");
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
	


}
 