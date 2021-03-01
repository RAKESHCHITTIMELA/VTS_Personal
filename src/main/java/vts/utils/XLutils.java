package vts.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutils 
{
  public static  FileInputStream fis;
  public static FileOutputStream fos;
  public static Workbook wb;
  public static Sheet ws;
  public static Row row;
  public static Cell cell;
  public static CellStyle style;
	
  
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
	    ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}
	
	public static short getColumnCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
	    ws = wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		short colcount= row.getLastCellNum();
		wb.close();
		fis.close();		
		return colcount;		
	}
	
	public static Object getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		DataFormatter formatter = new DataFormatter(); 
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
	    ws = wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		Object data;
		try 
		{
			cell=row.getCell(colnum);
		data =	formatter.formatCellValue(ws.getRow(rownum).getCell(colnum));
	//		data=cell.getStringCellValue();
		} catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fis.close();
		return data;
		
	}
	

	public static double getNumericCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
	    ws = wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		double data;
		try 
		{
			cell=row.getCell(colnum);
			data=cell.getNumericCellValue();
		} catch (Exception e) 
		{
			data=0;
		}
		wb.close();
		fis.close();
		return data;
		
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		
		
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
	    ws = wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		
	}
	
	public static boolean getBooleanCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
	    ws = wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		boolean data;
		try 
		{
			cell=row.getCell(colnum);
			data=cell.getBooleanCellValue();
		} catch (Exception e) 
		{
			data=false;
		}
		wb.close();
		fis.close();
		return data;
		
	}
	
	
	
	
	public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
	    ws = wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fos=new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	
	public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
	    ws = wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fos=new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	
	
//	public String getdata(String file,String sheet, int row, int col, int start, int end) throws IOException {
//		String num= XLutils.getCellData(file, sheet, row, col);
//		String mobilenumber = num.substring(start,end);
//		return mobilenumber;
//	}
	
	
}