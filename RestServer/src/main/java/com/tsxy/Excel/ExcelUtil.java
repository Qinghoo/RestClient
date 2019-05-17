package com.tsxy.Excel;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelUtil {
	public static void main(String[] args) {
		//web对象
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建表头等
		HSSFSheet sheet = wb.createSheet("test1");
		//创建行
		HSSFRow row = sheet.createRow(0);
		
		//创建列
		HSSFCell cell = row.createCell(0);
		
		HSSFCell cell2 = row.createCell(1);
		cell.setCellValue("编号");
		cell2.setCellValue("菜名");
	
		//sheet.addMergedRegion(new CellRangeAddress(0,0,0,0)); 
		
		try {
			FileOutputStream output = new FileOutputStream("d:\\JAKARTA.xls");
			wb.write(output);
			output.flush(); 
			System.out.println("成功创建excel文件");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	}
