package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;

public class Test {

	public static void main(String[] args) {
		
		XMLParser xp = new XMLParser();
//		ArrayList<Document> files = XMLParser.loadFiles("C:\\Users\\JSK\\Desktop\\EPG");
		ArrayList<EpgChannel> chnls = xp.chnls;
		
		
		
		XSSFSheet sheet = null;
		FileInputStream fis = null;
		XSSFCellStyle cs = null;
		try {
			fis = new FileInputStream("C://Users//JSK//Desktop//EPG.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileOutputStream outFile = null;
		XSSFWorkbook workbook = null;
		
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
		cs = ExcelHelper.createStyle(workbook);
		sheet = workbook.getSheetAt(0);
		CSVparser cp = new CSVparser(sheet, xp.chnls);
		cp.exportExcel(cs);

		File file = new File("EPG.xlsx");

		try {
			outFile = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			workbook.write(outFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			outFile.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
