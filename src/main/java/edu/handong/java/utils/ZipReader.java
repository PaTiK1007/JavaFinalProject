package edu.handong.java.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class ZipReader {

	public static ArrayList<String> ZipRead(String path) throws FileBrokenException {
		
		ArrayList<String> resultLines = new ArrayList<String> ();
		ZipFile zipFile;
		File dir = new File(path);
		
		for(File file : dir.listFiles()){
			
			String zipPath = file.getPath();
	
		
		try {
			zipFile = new ZipFile(zipPath);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
			
		    while(entries.hasMoreElements()){
		    	ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		    
		        ExcelReader myReader = new ExcelReader();
		        
		        for(String value:myReader.getData(stream)) {
		        	
		        	resultLines.add(value);
		        
		        }
		        
		        
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return resultLines;
	}
}
