package com.tsxy.util;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.tsxy.control.ProxyClient;
import com.tsxy.control.Service;
import com.tsxy.domain.Dish;
import com.tsxy.domain.ShoppingCar;

public class excel {
	public static void excelChu(String[] args) {
		//web对象
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建表头等
		HSSFSheet sheet = wb.createSheet("test1");
		//创建行
		HSSFRow row = sheet.createRow(0);
		
		//创建列
		HSSFCell cell = row.createCell(0);
		HSSFCell cell1=row.createCell(1);
		HSSFCell cell2 = row.createCell(2);
		cell.setCellValue("编号");
		cell1.setCellValue("菜名");
		cell2.setCellValue("数量");
		//sheet.addMergedRegion(new CellRangeAddress(0,0,0,0)); 
		Service service=ProxyClient.getClient(Service.class, "10.10.49.47", 6666);
		Map<String, Integer> treemap=new TreeMap<String, Integer>(service.findMonth());
		Set<String> dishs=treemap.keySet();
		Iterator<String> it=dishs.iterator();
		int i=0;
		System.out.println("\t菜名\t数量");
		
		while (it.hasNext()) {
			i++;
			HSSFRow row2=sheet.createRow(i);
			String k=it.next();
			String[] split = k.split("\t");
			
			Integer v=treemap.get(k);
			int j=0;
			for (String string : split) {
				HSSFCell h1=row2.createCell(j);
				h1.setCellValue(string);
				j++;
			}
			HSSFCell h1=row2.createCell(j);
			h1.setCellValue(v.intValue());
			
			/*for (int j = 0; j < 3; j++) {
				
					HSSFCell h1=row2.createCell(j);
				for (String string : split) {
					h1.setCellValue(string);
					h1.setCellValue(v.intValue());
					
				}
				
			}*/
			
			System.out.println(k+"\t"+v);
		}
		try {
			FileOutputStream output = new FileOutputStream("d:\\XIAOLIANG.xls");
			wb.write(output);
			output.flush(); 
			System.out.println("成功创建excel文件");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void excelxiaopiao(ShoppingCar car) {
	//web对象
	HSSFWorkbook wb = new HSSFWorkbook();
	//创建表头等
	HSSFSheet sheet = wb.createSheet("test1");
	//创建行
	HSSFRow row = sheet.createRow(0);
	HSSFRow row1 = sheet.createRow(1);
	HSSFRow row2 = sheet.createRow(2);
	HSSFRow row3 = sheet.createRow(3);
	//sheet.addMergedRegion(new CellRangeAddress(0,0,0,2));
	//创建列
	HSSFCell cell = row.createCell(0);
	HSSFCell cell21 = row1.createCell(0);
	HSSFCell cell31 = row2.createCell(0);
	HSSFCell cell41 = row3.createCell(0);
	HSSFCell cell42 = row3.createCell(1);
	HSSFCell cell43 = row3.createCell(2);
	
	
	/*HSSFCell cell1=row.createCell(1);
	HSSFCell cell2 = row.createCell(2);*/
	cell.setCellValue("小票如下");
	cell21.setCellValue(car.getRest());
	cell31.setCellValue("小票详单");
	cell41.setCellValue("菜名");
	cell42.setCellValue("数量");
	cell43.setCellValue("单价");
	 Map<Dish, Integer> maps = car.getDishMaps();
	 Set<Dish> dishs=maps.keySet();
	 Iterator<Dish> it=dishs.iterator();
	 int i=4;
	 while (it.hasNext()) {
		 
		 HSSFRow row0=sheet.createRow(i);
		 HSSFCell h1=row0.createCell(0);
		 HSSFCell h2=row0.createCell(1);
		 HSSFCell h3=row0.createCell(2);
		 
		 Dish dish = it.next();
		 Integer v=maps.get(dish);
		 h1.setCellValue(dish.getDishname());
		 h2.setCellValue(v.doubleValue());
		 
		 h3.setCellValue(dish.getDisprice());
		 i++;
	 }
	 sheet.createRow(i);
	 HSSFRow sum=sheet.createRow(i+1);
	 
	 sum.createCell(1).setCellValue("总价：");
	 sum.createCell(2).setCellValue(car.getSumPrice());;
	 
	 HSSFRow shou=sheet.createRow(i+2);
	 shou.createCell(1).setCellValue("收钱");
	 shou.createCell(2).setCellValue(car.getShouPrice());
	 HSSFRow zhao=sheet.createRow(i+3);
	 zhao.createCell(1).setCellValue("找零");
	 zhao.createCell(2).setCellValue(car.getZhaoPrice());
	
	try {
		FileOutputStream output = new FileOutputStream("d:\\Xiaopiao.xls");
		wb.write(output);
		output.flush(); 
		System.out.println("成功创建excel文件");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	
	}
