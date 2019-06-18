package edu.handong.java.utils;


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
		
		private static String id;
		private HashMap<String, ArrayList<FirstDataSheet>> firstData = new HashMap<String, ArrayList<FirstDataSheet>>();
		private HashMap<String, ArrayList<SecondDataSheet>> secondData = new HashMap<String, ArrayList<SecondDataSheet>>();
		
		
		public void getData(InputStream excelFile, String studentID, String path) {
			
			ArrayList<String> values = new ArrayList<String>();
			
			ArrayList<FirstDataSheet> firstTemp = new ArrayList<FirstDataSheet>();
			ArrayList<SecondDataSheet> secondTemp = new ArrayList<SecondDataSheet>();
			
			id = studentID;
			
			try (InputStream inp = excelFile) {
			        Workbook wb = WorkbookFactory.create(inp);
			        Sheet sheet = wb.getSheetAt(0);
			        Row firstRow = sheet.getRow(0);
			        Cell firstCell = firstRow.getCell(0);
			        
			        if(firstCell.getStringCellValue().equals("제목")) {
			        	int i=1;
				        int j=0;
				        
			        	try{
			        		if(firstRow.getPhysicalNumberOfCells()>7) {
				        		throw new FileBrokenException(inp);
			        		}
			        	}catch(FileBrokenException e) {
			        		System.out.println(e.getMessage());
			        		System.exit(0);
			        	}
			        	
				        
				        while(true){ 	
				        	Row row = sheet.getRow(i);
				        	if(row==null) {
				        		break;
				        	}
				        	Cell cell = row.getCell(j++);
				        	
				        	
				        	if(cell==null && j==7) {
				        		i++;
				        		j=0;
				        		FirstDataSheet firstData = new FirstDataSheet(values);
				        		firstTemp.add(firstData);
				        		values.clear();
				        		
				        		
				        	}else if(cell==null && j<=7){
				        		cell = row.createCell(0);
				        		cell.setCellValue(" ");
				        		values.add(cell.getStringCellValue());
				        		
				        		
				        	}
				        	
				        }
				        firstData.put(id, firstTemp);
			        }else {
			        	int i=2;
			        	int j=0;
			        	
			        	try{
			        		Row secondChecker = sheet.getRow(1);
			        		if(secondChecker.getPhysicalNumberOfCells()>5) {
				        		throw new FileBrokenException(inp);
			        		}
			        	}catch(FileBrokenException e) {
			        		System.out.println(e.getMessage());
			        		System.exit(0);
			        	}
			        	
			        	
			        	while(true){
			        		Row row = sheet.getRow(i);
			        		if(row==null) {
			        			break;
			        		}
			        		Cell cell = row.getCell(j++);
			        		if(cell==null && j==6) {
			        			i++;
			        			j=0;
			        			SecondDataSheet secondData = new SecondDataSheet(values);
			        			secondTemp.add(secondData);
			        			values.clear();
			        		}else if(cell==null && j<=5) {
				        		cell = row.createCell(0);
				        		cell.setCellValue(" ");
				        		values.add(cell.getStringCellValue());
			        		}
			        	}
			        	secondData.put(id, secondTemp);
			        }
			    } catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		public HashMap<String, ArrayList<FirstDataSheet>> getFirstData() {
			return firstData;
		}

		public HashMap<String, ArrayList<SecondDataSheet>> getSecondData() {
			return secondData;
		}
	}