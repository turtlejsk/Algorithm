package test;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelHelper{
	

	public static void createCell(char column, int row, String data, XSSFSheet sheet, XSSFCellStyle cellStyle) {
		XSSFCell cell = sheet.createRow(row-1).createCell(getIndex(column)-1);

		cell.setCellValue(data);
		cell.setCellStyle(cellStyle);
	}
	public static void createCell(String column, int row, String data, XSSFSheet sheet, XSSFCellStyle cellStyle) {
		XSSFCell cell = sheet.getRow(row-1).createCell(getIndex(column)-1);
		cell.setCellValue(data);
		cell.setCellStyle(cellStyle);
	}
	public static void createCell(String column, int row, int data, XSSFSheet sheet, XSSFCellStyle cellStyle) {
		XSSFCell cell = sheet.getRow(row-1).createCell(getIndex(column)-1);
		cell.setCellValue(data);
		cell.setCellStyle(cellStyle);
	}
	public static XSSFCellStyle createStyle(XSSFWorkbook workbook) {
		XSSFCellStyle cs = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight((short)8);
		font.setFontHeightInPoints((short)8);
		font.setBoldweight((short)700);
		font.setFontName("Arial");
		cs.setFont(font);
		cs.setAlignment(XSSFCellStyle.ALIGN_LEFT);  
		cs.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		cs.setBorderTop(XSSFCellStyle.BORDER_THIN);
		cs.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		cs.setBorderRight(XSSFCellStyle.BORDER_THIN);
		return cs;
	}
	public static int getIndex(String str) {
		char[] chars = str.toCharArray();
		int index = 0;
		int temp;
		for(int i=0;i<chars.length;++i) {
			temp = getIndex(chars[i]);
			if(temp<0)
				return -1;
			temp*=Math.pow('z'-'a'+1, chars.length-i-1);
			index+=temp;
		}
		return index;
	}
	public static int getIndex(char alphabet) {
		if('a'<=alphabet&&alphabet<='z') {
			return alphabet - 'a'+1;
		}
		if('A'<=alphabet&&alphabet<='Z') {
			return alphabet - 'A'+1;
		}
		return -1;
	}
	
}
