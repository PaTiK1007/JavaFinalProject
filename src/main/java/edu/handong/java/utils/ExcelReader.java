package edu.handong.java.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import edu.handong.java.data.FirstDataSheet;
import edu.handong.java.data.SecondDataSheet;

public class ExcelReader {
	
	
	public List<FirstDataSheet> getData(InputStream path) throws FileBrokenException {
		List<FirstDataSheet> values = new ArrayList<FirstDataSheet>();
		InputStream fis = null;
		HSSFWorkbook workbook = null;
		
		
		
		try {
			fis = path;
			workbook = new HSSFWorkbook(fis);
			
			HSSFSheet curSheet;
			HSSFRow curRow;
			HSSFCell curCell;
			
			FirstDataSheet ds1;
			SecondDataSheet ds2;
			
			for(int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets();sheetIndex++) {
				curSheet = workbook.getSheetAt(sheetIndex);
				
				for(int rowIndex = 0; rowIndex< curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					
					if(rowIndex !=0) {
						
						curRow = curSheet.getRow(rowIndex);
						ds1 = new FirstDataSheet();
						ds2 = new SecondDataSheet();
						String val;
						
						if(!"".equals(curRow.getCell(0).getStringCellValue())){
							
							for(int cellIndex = 0; cellIndex<curRow.getPhysicalNumberOfCells();cellIndex++) {
								
								curCell = curRow .getCell(cellIndex);
										
								if(true) {
									val = "";
									
									switch (curCell.getCellType()) {
										case NUMERIC:
											val = curCell.getNumericCellValue()+"";
											break;
										case ERROR:
											throw new FileBrokenException();
											
										case BLANK:
											val = curCell.getBooleanCellValue()+"";
											break;
											
										default:
											val = new String();
											break;
									}
									
									switch(cellIndex) {
									case 0: 
										ds.setTitle(val);
										break;
										
									case 1:
										ds.setSummary(val);
										break;
										
									case 2:
										ds.setPicNum(val);
										break;
										
									case 3:
										ds.setDate(val);
										break;
										
									case 4:
										ds.setDomain(val);
										break;
										
									case 5:
										ds.setSource(val);
										break;
										
									case 6:
										ds.setCopyright(val);
										break;
									
									}
									
								}
							}
							values.add(ds);
						}
						
					}
				}
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		} catch(FileBrokenException e) {
			
		}finally {
			try {
				if(workbook != null) workbook.close();
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return values;
		
	}
}
