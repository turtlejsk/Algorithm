package test;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class CSVparser {

	ArrayList<EpgChannel> chnls;
	XSSFSheet sheet;
	int index =2;
	public CSVparser(XSSFSheet sheet, ArrayList<EpgChannel> chnls) {
		this.sheet = sheet;
		this.chnls = chnls;
		
	}
	
	

	public void exportExcel(XSSFCellStyle cs) {
		
		EpgChannel tempCh = null;
		Program tempPrg = null;
		EpgDescription tempDesc = null;

		for (int i = 0; i < chnls.size(); i++) {
			tempCh = this.chnls.get(i);
			for (int j = 0; j < tempCh.programs.size(); j++) {
				tempPrg = tempCh.programs.get(j);
				tempDesc = tempPrg.desc;
				sheet.createRow(index - 1);
				ExcelHelper.createCell("a", index, tempCh.serviceRef, this.sheet, cs);
				ExcelHelper.createCell("b", index, PeriodConverter.convert(tempCh.period.start), this.sheet, cs);
				ExcelHelper.createCell("c", index, PeriodConverter.convert(tempCh.period.end), this.sheet, cs);
				ExcelHelper.createCell("d", index, tempCh.channelName, this.sheet, cs);
				ExcelHelper.createCell("e", index, tempPrg.id, this.sheet, cs);
				ExcelHelper.createCell("f", index, tempPrg.action, this.sheet, cs);
				ExcelHelper.createCell("g", index, PeriodConverter.convert(tempPrg.period.start), this.sheet, cs);
				ExcelHelper.createCell("h", index, PeriodConverter.convert(tempPrg.period.end), this.sheet, cs);
				ExcelHelper.createCell("i", index, tempDesc.DVB_Content, this.sheet, cs);
				ExcelHelper.createCell("j", index, tempDesc.Parental_Rating, this.sheet, cs);
				ExcelHelper.createCell("k", index, tempDesc.Directors, this.sheet, cs);
				ExcelHelper.createCell("l", index, tempDesc.Actors, this.sheet, cs);
				ExcelHelper.createCell("m", index, tempDesc.language, this.sheet, cs);
				ExcelHelper.createCell("n", index, tempDesc.title, this.sheet, cs);
				ExcelHelper.createCell("o", index, tempDesc.Description, this.sheet, cs);
				index++;

			}

		}

	}

//	public static void main(String argv[]) {
//
//		ArrayList<Document> files = XMLParser.loadFiles("C:\\Users\\JSK\\Desktop\\EPG");
//		ArrayList<EpgChannel> chnls = XMLParser.createEpg(files);
//		XSSFSheet sheet = null;
//		FileInputStream fis = null;
//		XSSFCellStyle cs = null;
//		try {
//			fis = new FileInputStream("C://Users//JSK//Desktop//EPG.xlsx");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		FileOutputStream outFile = null;
//		XSSFWorkbook workbook = null;
//
//		try {
//			workbook = new XSSFWorkbook(fis);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		cs = ExcelHelper.createStyle(workbook);
//		sheet = workbook.getSheetAt(0);
//
//		sheet = exportExcel(sheet, chnls, cs);
//
//		File file = new File("EPG.xlsx");
//
//		try {
//			outFile = new FileOutputStream(file);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		try {
//			workbook.write(outFile);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			outFile.close();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			fis.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			workbook.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
