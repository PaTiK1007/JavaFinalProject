package edu.handong.java.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import edu.handong.java.data.FirstDataSheet;
import edu.handong.java.data.SecondDataSheet;

public class ExcelReader {
		
		private String id;
	
		private ArrayList<String> errorZip = new ArrayList<String>(0);
		private HashMap<String, ArrayList<FirstDataSheet>> firstType = new HashMap<String, ArrayList<FirstDataSheet>>();
		private HashMap<String, ArrayList<SecondDataSheet>> secondType = new HashMap<String, ArrayList<SecondDataSheet>>();
		
		
	public ArrayList<String> getData(String path) throws FileBrokenException {
		
		
		ArrayList<FirstDataSheet> firstValues = new ArrayList<String>();
		
		
		System.out.println(path);
		
		try (InputStream inp = new FileInputStream(path)) {
			
		        Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		        
		        for(int i = 1; i <= sheet.getLastRowNum();i++) {
		        	Row row = sheet.getRow(i);
		        for(int j =0; j<=row.getLastCellNum();j++) {
		        	Cell cell = row.getCell(j);
		        	
		        if(cell.equals("1. 찾은 자료 내에 있는 그림이나 표의 자료내 위치(쪽번호)와 표와 그림을 설명하는 캡션(주석)을 적습니다.")) {
		        		
			    }else if (cell == null) {
		           cell = row.createCell(0);
		        }else if (cell.getCellType()== CellType.ERROR) {
		        	throw new FileBrokenException("Celltype Error");
		        }
		        
		        	firstValues.add(cell.getStringCellValue());
		        	}
		        }
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileBrokenException e) {
				errorZip.add()
			}
		
		return firstValues;
	}
	
	public ArrayList<String> getData(InputStream is) {
		ArrayList<String> values = new ArrayList<String>();
		
		try (InputStream inp = is) {
		    //InputStream inp = new FileInputStream("workbook.xlsx");
		    
		        Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		        
		        for(int i = 0; i <= sheet.getLastRowNum();i++) {
		        	Row row = sheet.getRow(i);
		        for(int j =0; j<=row.getLastCellNum();j++) {
		        	Cell cell = row.getCell(j);
		        if (cell == null)
		            cell = row.createCell(0);
		        
		        	values.add(cell.getStringCellValue());
		        	}
		        }
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return values;
	}
}