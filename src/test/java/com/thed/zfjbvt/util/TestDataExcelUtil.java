package com.thed.zfjbvt.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.thed.zfjbvt.Config;

public class TestDataExcelUtil {
	private static FileInputStream file=null;
	private static Workbook wb=null;
	private static Sheet sheet=null;
	public TestDataExcelUtil() throws Throwable {
		setFile();
		setWorkbook();
	}
	public static void setFile() throws Throwable{
		try{
			if(file == null){
				file=new FileInputStream(Config.getValue("TEST_DATA_EXCEL_PATH"));
			}
		}catch(Throwable e){
			throw e;
		}
	}
	public static void setWorkbook() throws Throwable{
		try{
			if(wb == null ){
			   if(file != null)
				wb=WorkbookFactory.create(file);
			   else {
				   setFile();
				   wb=WorkbookFactory.create(file); 
			   }
			}
		}catch(Throwable e){
			throw e;
		}
	}
	
	
	public static int getTotalRow(Sheet sheet) throws Throwable {
		setFile();
		setWorkbook();
		//sheet=wb.getSheet(Config.getValue("EXCEL_SHEET_NAME"));
		int totalRow=sheet.getLastRowNum();
	return totalRow;
	}
/*public static int getlastColumnNumber(String fileName, String sheetName, int colNumber, int startRowNum, int lastRowOfSheet) throws InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream(fileName);
		Workbook wb=WorkbookFactory.create(fis);
		sheet=wb.getSheet(sheetName);
		int totalCol=sheet.getRow(colNumber).getLastCellNum();
	return totalCol;
}*/
public static int getFirstRowNum(Sheet sheet, int colNum, String textType, int totalRow) throws Throwable{
	setFile();
	setWorkbook();
	//sheet=wb.getSheet(Config.getValue("EXCEL_SHEET_NAME"));
	int currentRowNum=0;
	for(int i=0; i< totalRow; i++){
		//System.out.println(sheet.getRow(i).getCell(colNum).getStringCellValue());
		sheet.getRow(i).getCell(colNum).setCellType(Cell.CELL_TYPE_STRING);
		if(sheet.getRow(i).getCell(colNum).getStringCellValue().equals(textType)){
			currentRowNum=sheet.getRow(i).getRowNum();
			break;
		}
	}
	
	return currentRowNum;
}
	
	public static int getLastRowNum(Sheet sheet, int colNum, String textType, int totalRow) throws Throwable{
		//setWorkbook();
		//sheet=wb.getSheet(Config.getValue("EXCEL_SHEET_NAME"));
		
		int getFirstRowNumber=getFirstRowNum(sheet, colNum, textType, totalRow);
		int currentRowNum=getFirstRowNumber;
		for(int i=getFirstRowNumber; i<= totalRow; i++){
			sheet.getRow(i).getCell(colNum).setCellType(Cell.CELL_TYPE_STRING);
			if(sheet.getRow(i).getCell(colNum).getStringCellValue().equals(textType)){
				//currentRowNum=sh.getRow(i).getRowNum();
				currentRowNum++;
			}else{
				currentRowNum=sheet.getRow(i).getRowNum();
				System.out.println(currentRowNum);
				break;
			}
		}
		
		return currentRowNum;
	}
	public static List<String> getColData(Sheet sheet, int startRow, int endRow, String colName) throws Throwable{
		List<String> list=new ArrayList<String>();
		setWorkbook();
		//sheet=wb.getSheet(Config.getValue("EXCEL_SHEET_NAME"));
		int colNumber=getHeaderColNum(sheet, colName)+1;
		for(int i=startRow; i< endRow; i++){
			Row r=sheet.getRow(i);
			Cell c=r.getCell(colNumber);
			String data=c.getStringCellValue();
			//System.out.println("Summary = "+data);
			list.add(data);
		}
		
		return list;
	}
	public static List<String> getColDataForTestStep(Sheet sheet, int startRow, int endRow, String colName) throws Throwable{
		List<String> list=new ArrayList<String>();
		setWorkbook();
		//sheet=wb.getSheet(Config.getValue("EXCEL_SHEET_NAME"));
		int colNumber=getHeaderColNum(sheet, colName)+1;
		for(int i=startRow; i< endRow; i++){
			Row r=sheet.getRow(i);
			Cell c=r.getCell(colNumber);
			String data=c.getStringCellValue();
			//System.out.println("Summary = "+data);
			list.add(data);
		}
		
		return list;
	}
	public static Map<String, Map<String, String>> getRowData(String type, String colName) throws Throwable{
		setWorkbook();
		sheet=wb.getSheet(Config.getValue("EXCEL_SHEET_NAME"));
		int colNum=getHeaderColNum(sheet, colName);
		int totalRow=getTotalRow(sheet);
		System.out.println(totalRow);
		int firstRow=getFirstRowNum(sheet, colNum, type, totalRow);
		int lastRow=getLastRowNum(sheet, colNum, type, totalRow);
		
		Map<String, Map<String, String>> testData=new HashMap<String, Map<String, String>>();
		
		int colNumber=getHeaderColNum(sheet, colName)+1;
		
		for(int i=firstRow; i< lastRow; i++){
			int totalCol=sheet.getRow(i).getLastCellNum();
			//String description=null;
			Map<String, String> exceldata=new HashMap<String, String>();
			for(int j=colNumber; j< totalCol; j++){
				String affectedVersion=null;
				String fixedVersion=null;
				String component=null;
				String label=null;
				String priority=null;
				String enviroment=null;
				String description=null;
				String colHeader=sheet.getRow(sheet.getFirstRowNum()).getCell(j).getStringCellValue();
				if(colHeader.equals("summary")){
					//String description= new String(sheet.getRow(i).getCell(j).getStringCellValue());
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					exceldata.put("summary", sheet.getRow(i).getCell(j).getStringCellValue());
				} else if (colHeader.equals("Affected Version")){
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					//affectedVersion=String.valueOf(sheet.getRow(i).getCell(j).getNumericCellValue());
					affectedVersion=sheet.getRow(i).getCell(j).getStringCellValue();
					if(affectedVersion.equals("1")){
						affectedVersion=Config.getValue("VERSION_ONE");
					}else if(affectedVersion.equals("2")){
						affectedVersion=Config.getValue("VERSION_TWO");
					}else if(affectedVersion.equals("3")){
						affectedVersion=Config.getValue("VERSION_THREE");
					}
					exceldata.put("affectedVersion", affectedVersion);
				}else if(colHeader.equals("Fixed Version")){
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					fixedVersion=sheet.getRow(i).getCell(j).getStringCellValue();
					if(fixedVersion.equals("1")){
						fixedVersion=Config.getValue("VERSION_ONE");
					}else if(fixedVersion.equals("2")){
						fixedVersion=Config.getValue("VERSION_TWO");
					}else if(fixedVersion.equals("3")){
						fixedVersion=Config.getValue("VERSION_THREE");
					}
					exceldata.put("fixedVersion", fixedVersion);
				}else if(colHeader.equals("Component")){
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					component=sheet.getRow(i).getCell(j).getStringCellValue();
					if(component.equals("1")){
						component=Config.getValue("COMPONENT_ONE");
					}else if(component.equals("2")){
						component=Config.getValue("COMPONENT_TWO");
					}else if(component.equals("3")){
						component=Config.getValue("COMPONENT_THREE");
					}
					exceldata.put("component", component);
				}else if(colHeader.equals("Label")){
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					label=sheet.getRow(i).getCell(j).getStringCellValue();
					exceldata.put("label", label);
				}else if(colHeader.equals("Priority")){
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					priority=sheet.getRow(i).getCell(j).getStringCellValue();
					if(priority.equals("1")){
						priority=Config.getValue("PRIORITY_ONE");
					}else if(priority.equals("2")){
						priority=Config.getValue("PRIORITY_TWO");
					}else if(priority.equals("3")){
						priority=Config.getValue("PRIORITY_THREE");
					}else if(priority.equals("4")){
						priority=Config.getValue("PRIORITY_FOUR");
					}
					exceldata.put("priority", priority);
				} else if(colHeader.equals("Enviroment")){
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					enviroment=sheet.getRow(i).getCell(j).getStringCellValue();
					exceldata.put("enviroment", enviroment);
				}else if(colHeader.equals("Description")){
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					description=sheet.getRow(i).getCell(j).getStringCellValue();
					exceldata.put("description", description);
				}
				
				
			}
			
			testData.put(exceldata.get("summary"), exceldata);
			System.out.println("print");
		}
		return testData;
	}
	public static Map<String, Map<String, String>> getStepData(String type, String colName) throws Throwable{
		setWorkbook();
		System.out.println(Config.getValue("STEP_EXCEL_SHEET_NAME"));
		sheet=wb.getSheet(Config.getValue("STEP_EXCEL_SHEET_NAME"));
		int colNum=getHeaderColNum(sheet, colName);
		int totalRow=getTotalRow(sheet);
		int firstRow=getFirstRowNum(sheet, colNum, type, totalRow);
		System.out.println(firstRow);
		int lastRow=getLastRowNum(sheet, colNum, type, totalRow);
		System.out.println(lastRow);
		Map<String, Map<String, String>> testData=new HashMap<String, Map<String, String>>();
		
		
		int colNumber=getHeaderColNum(sheet, colName)+1;
		
		for(int i=firstRow; i< lastRow; i++){
			int totalCol=sheet.getRow(i).getLastCellNum();
			//String description=null;
			Map<String, String> exceldata=new HashMap<String, String>();
			//List<String> excelData= new ArrayList<String>();
			for(int j=colNumber; j< totalCol; j++){
				sheet.getRow(sheet.getFirstRowNum()).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
				String colHeader=sheet.getRow(sheet.getFirstRowNum()).getCell(j).getStringCellValue();
				if(colHeader.equals("Test Step")){
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					exceldata.put("test step", sheet.getRow(i).getCell(j).getStringCellValue());
					//excelData.add(sheet.getRow(i).getCell(j).getStringCellValue());
				} else if (colHeader.equals("Test Data")){
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					exceldata.put("test data", sheet.getRow(i).getCell(j).getStringCellValue());
					//excelData.add(sheet.getRow(i).getCell(j).getStringCellValue());
				}else if(colHeader.equals("Test Result")){
					sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
					exceldata.put("test result", sheet.getRow(i).getCell(j).getStringCellValue());
					//excelData.add(sheet.getRow(i).getCell(j).getStringCellValue());
				}
				
			}
			
			testData.put(exceldata.get("test step"), exceldata);
			System.out.println("print");
		}
		return testData;
	}
	/*public static List<String> getIssueTypeData(String header, String type, String colName) throws Throwable{
		int colNum=getHeaderColNum(header);
		int totalRow=getTotalRow();
		int firstRow=getFirstRowNum(colNum, type, totalRow);
		int lastRow=getLastRowNum(colNum, type, totalRow);
		List<String > list=getData(firstRow, lastRow, colName);
		//List<List<String>> list
		return list;
	}*/
	public static List<String> getTestStepDescription(String type, String colName) throws Throwable{
		setWorkbook();
		sheet=wb.getSheet(Config.getValue("STEP_EXCEL_SHEET_NAME"));
		int colNum=getHeaderColNum(sheet,colName);
		int totalRow=getTotalRow(sheet);
		int firstRow=getFirstRowNum(sheet, colNum, type, totalRow);
		int lastRow=getLastRowNum(sheet, colNum, type, totalRow);
		List<String > list=getColDataForTestStep(sheet, firstRow, lastRow, colName);
		
		return list;
	}
	public static List<String> getIssueTypeSummary(String type, String colName) throws Throwable{
		setWorkbook();
		sheet=wb.getSheet(Config.getValue("EXCEL_SHEET_NAME"));
		int colNum=getHeaderColNum(sheet,colName);
		int totalRow=getTotalRow(sheet);
		int firstRow=getFirstRowNum(sheet, colNum, type, totalRow);
		int lastRow=getLastRowNum(sheet, colNum, type, totalRow);
		List<String > list=getColData(sheet, firstRow, lastRow, colName);
		
		return list;
	}
	public static int getHeaderColNum(Sheet sheet, String text) throws Throwable{
		//setWorkbook();
		int currentColNum=0;
		//sheet=wb.getSheet(Config.getValue("EXCEL_SHEET_NAME"));
		int rowNum=sheet.getFirstRowNum();
		Row r=sheet.getRow(rowNum);
		int colNum=r.getLastCellNum();
		for(int i=0; i< colNum; i++){
			r.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
			if(r.getCell(i).getStringCellValue().equals(text)){
				currentColNum=r.getCell(i).getColumnIndex();
				break;
			}
		}
		//System.out.println(text+" column number : "+currentColNum);
		return currentColNum;
	}
	/*public static void main(String args[]) throws Throwable{
		System.out.println(getHeaderColNum("issue type"));
		int totalRow=getTotalRow();
		int firstRow=getFirstRowNum(1, "Test", totalRow);
		System.out.println("Total Rows = "+totalRow);
		System.out.println("First Row  Number = "+firstRow);
		int lastRow=getLastRowNum(1, "Test", totalRow);
		System.out.println("Last Row  Number = "+lastRow);
		System.out.println("Total Tests = "+(lastRow - firstRow));
		List<String > list=getData( firstRow, lastRow);
		for(int i=0; i< list.size(); i++){
			System.out.println(list.get(i));
		}
		
	}*/
	/*public static Map<String, Map<String, String>> getRowData(int startRow, int endRow, String colName) throws Throwable{
		int colNum=getHeaderColNum(header);
		int totalRow=getTotalRow();
		int firstRow=getFirstRowNum(colNum, type, totalRow);
		int lastRow=getLastRowNum(colNum, type, totalRow);
		Map<String, String> exceldata=new HashMap<String, String>();
		Map<String, Map<String, String>> testData=new HashMap<String, Map<String, String>>();
		setWorkbook();
		sheet=wb.getSheet(Config.getValue("EXCEL_SHEET_NAME"));
		int colNumber=getHeaderColNum(colName);
		String description=null;
		for(int i=startRow; i< endRow; i++){
			int totalCol=sheet.getRow(i).getLastCellNum();
		
			for(int j=colNumber; j<= totalCol; j++){
				description=sheet.getRow(i).getCell(j).getStringCellValue();
				String affectedVersion=sheet.getRow(i).getCell(j).getStringCellValue();
				if(affectedVersion.equals("1")){
					affectedVersion=Config.getValue("VERSION_ONE");
				}else if(affectedVersion.equals("2")){
					affectedVersion=Config.getValue("VERSION_TWO");
				}else if(affectedVersion.equals("3")){
					affectedVersion=Config.getValue("VERSION_THREE");
				}
				String fixedVersion=sheet.getRow(i).getCell(j).getStringCellValue();
				if(fixedVersion.equals("1")){
					fixedVersion=Config.getValue("VERSION_ONE");
				}else if(fixedVersion.equals("2")){
					fixedVersion=Config.getValue("VERSION_TWO");
				}else if(fixedVersion.equals("3")){
					fixedVersion=Config.getValue("VERSION_THREE");
				}
				String component=sheet.getRow(i).getCell(j).getStringCellValue();
				if(component.equals("1")){
					component=Config.getValue("COMPONENT_ONE");
				}else if(component.equals("2")){
					component=Config.getValue("COMPONENT_TWO");
				}else if(component.equals("3")){
					component=Config.getValue("COMPONENT_THREE");
				}
				String label=sheet.getRow(i).getCell(j).getStringCellValue();
				exceldata.put("description", description);
				exceldata.put("affectedVersion", affectedVersion);
				exceldata.put("fixedVersion", fixedVersion);
				exceldata.put("component", component);
				exceldata.put("label", label);
			}
			
			testData.put(description, exceldata);
		}
		return testData;
	}*/
	
}



