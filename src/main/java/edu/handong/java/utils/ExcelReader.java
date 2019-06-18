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
		private HashMap<String, ArrayList<FirstDataSheet>> firstDataMap = new HashMap<String, ArrayList<FirstDataSheet>>();
		private HashMap<String, ArrayList<SecondDataSheet>> secondDataMap = new HashMap<String, ArrayList<SecondDataSheet>>();
		
		
		public void getData(InputStream excelFile, String studentID) {
			
			ArrayList<String> values = new ArrayList<String>();
			
			ArrayList<FirstDataSheet> firstTemp = new ArrayList<FirstDataSheet>();
			ArrayList<SecondDataSheet> secondTemp = new ArrayList<SecondDataSheet>();
			
			id = studentID;
			
			try (InputStream inp = excelFile) {
			        Workbook wb = WorkbookFactory.create(inp);
			        Sheet sheet = wb.getSheetAt(0);
			        Row firstRow = sheet.getRow(0);
			        Row secondRow = sheet.getRow(1);
			        Cell firstCell = firstRow.getCell(0);
			        
			        
			        if(firstCell.getStringCellValue().equals("제목")) {
			        	
				        
			        	try{
			        		if(firstRow.getPhysicalNumberOfCells()>7) {
				        		throw new FileBrokenException(inp);
			        		}
			        	}catch(FileBrokenException e) {
			        		System.out.println(e.getMessage());
			        		System.exit(0);
			        	}
			        	
			        	Sheet sheetCal = wb.getSheetAt(0);
				        
				        for(int i = 1; i <= sheetCal.getLastRowNum();i++) {
				        	Row row = sheetCal.getRow(i);
				        	
					        for(int j = 0; j <= 6; j++) {
					        	Cell cell = row.getCell(j);
					        	
						        if (cell == null) {
						            cell = row.createCell(0);
					        		values.add(cell.getStringCellValue());
				        		}else if(cell.getCellType() == CellType.NUMERIC) {
			        				values.add(Double.toString(cell.getNumericCellValue()));
			        			}else if(cell.getCellType() == CellType.BLANK){
			        				cell.setCellValue(" ");
			        				values.add(cell.getStringCellValue());
			        			}else {
				        			values.add(cell.getStringCellValue());
			        			}
				        
						        if(j==6) {
						        	FirstDataSheet firstData = new FirstDataSheet(values);
						        	firstTemp.add(firstData);
						        	values.clear();
						        	}
				        	
				        }
				     }
				       firstDataMap.put(id, firstTemp);
			        }else {
			        	
			        	try{
			        		if(secondRow.getPhysicalNumberOfCells()>5) {
				        		throw new FileBrokenException(inp);
			        		}
			        	}catch(FileBrokenException e) {
			        		System.out.println(e.getMessage());
			        		System.exit(0);
			        	}
			        	
			        	Sheet sheetCal = wb.getSheetAt(0);
			    
			        	for(int i = 2; i <= sheetCal.getLastRowNum();i++) {
				        	Row row = sheetCal.getRow(i);
				        	
					        for(int j = 0; j <= 4; j++) {
					        	Cell cell = row.getCell(j);
					        	
					        	if (cell == null) {
						            cell = row.createCell(0);
					        		values.add(cell.getStringCellValue());
				        		}else if(cell.getCellType() == CellType.NUMERIC) {
			        				values.add(Double.toString(cell.getNumericCellValue()));
			        			}else if(cell.getCellType() == CellType.BLANK){
			        				cell.setCellValue(" ");
			        				values.add(cell.getStringCellValue());
			        			}else {
				        			values.add(cell.getStringCellValue());
			        			}
				        
				        
						        if(j==4) {
						        	SecondDataSheet secondData = new SecondDataSheet(values);
				        			secondTemp.add(secondData);
				        			values.clear();
						        	}
				        	
				        }
				     }
			        		
			        	secondDataMap.put(id, secondTemp);
			        }
			    } catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		public HashMap<String, ArrayList<FirstDataSheet>> getFirstData() {
			return firstDataMap;
		}

		public HashMap<String, ArrayList<SecondDataSheet>> getSecondData() {
			return secondDataMap;
		}
	}