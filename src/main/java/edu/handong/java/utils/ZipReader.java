package edu.handong.java.utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import edu.handong.java.data.FirstDataSheet;
import edu.handong.java.data.SecondDataSheet;

public class ZipReader {
	
	static ExcelReader excelReader = new ExcelReader();
	
	public static void readZIPAndWriteCSV(String input, String output) throws IOException{
		File dir = new File(input);
		
		for(File file:dir.listFiles()) {
			String fileName= file.getName();
			String stID = fileName.split(".z")[0].trim();
			readZip(file.getPath(),stID);
		}
		
		writeAFile(output);
		
	}
	
	public static void readZip(String path,String id) {
		
		ZipFile zipFile;
		
		try {
			zipFile = new ZipFile(path);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
			
		    while(entries.hasMoreElements()){
		    	ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		        excelReader.getData(stream, id, path);
		        
		    }  
		    zipFile.close();
		    
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void writeAFile (String outputPath) {
		
		String firstFileName = "result1.csv";
		String secondFileName = "result2.csv";
		
		 Map<String, ArrayList<FirstDataSheet>> firstDataMap = new TreeMap<String, ArrayList<FirstDataSheet>>(excelReader.getFirstData());
	     Map<String, ArrayList<SecondDataSheet>> sortedSecondType = new TreeMap<String, ArrayList<SecondDataSheet>>(excelReader.getSecondData());
		
		try {
	         File fp1= new File(firstFileName);
	         File fp2= new File(secondFileName);
	         
	         FileOutputStream fos1 = new FileOutputStream(fp1);
	         DataOutputStream dos1 =new DataOutputStream(fos1);
	         
	         FileOutputStream fos2 = new FileOutputStream(fp2);
	         DataOutputStream dos2 =new DataOutputStream(fos2);
	         
	       
	 		ArrayList<String> lines1 = new ArrayList<String>();
	 		ArrayList<String> lines2 = new ArrayList<String>();
	 		 
	 		for(String key:firstDataMap.keySet()) {
	 			for(FirstDataSheet dats:excelReader.getFirstData().get(key)) {
	 				String title = dats.getTitle();
	 				String summary = dats.getSummary();
	 				String keyword = dats.getKeyword();
	 				String date = dats.getDate();
	 				String domain = dats.getDomain();
	 				String source = dats.getSource();
	 				String copyright = dats.getCopyright();
	 				
	 				lines1.add(key +","+ "\""+title+"\"" + ","+ "\""+ summary+ "\"" + ","+"\""+keyword+"\""+","+"\""+date+"\""+","+"\""+domain+"\""+","+"\""+source+"\""+ "," +"\""+copyright+"\"");
	 				
	 			}
	 		}
	         
	        
	 		
	 		for(String key:sortedSecondType.keySet()) {
	 			for(SecondDataSheet dats:excelReader.getSecondData().get(key)) {
	 				String title = dats.getTitle();
	 				String picNum = dats.getPicNum();
	 				String Type = dats.getType();
	 				String caption = dats.getCaption();
	 				String pageNum = dats.getPage();
	 				
	 				lines2.add(key+","+"\""+title+"\""+","+"\""+picNum+"\""+","+"\""+Type+"\""+","+"\""+caption+"\""+","+"\""+pageNum+"\"");
	 			}
	 		}
	 		
	 		 for(String line:lines1){
		            dos1.write((line+"\n").getBytes());
		         }
		         dos1.close();
		         fos1.close();
		         
		         for(String line:lines2){
			            dos2.write((line+"\n").getBytes());
			         }
			         dos2.close();
			         fos2.close();    
	      } catch (IOException e) {
	         e.printStackTrace();
	      } 
			System.out.println("complete");
		
		
		
		
		
	   }


	
}

