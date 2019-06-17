package edu.handong.java.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

import edu.handong.java.data.FirstDataSheet;

public class ZipReader {

	public ArrayList<String> ZipReader(String path) throws FileBrokenException {
		
		ArrayList<String> resultLines = new ArrayList<String> ();
		ZipFile zipFile;
		File dir = new File(path);
		String line;
		boolean next =false;
		
		for(File file : dir.listFiles()){
			
			String zipPath = file.getPath();
	
		
		try {
			zipFile = new ZipFile(zipPath);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
			
		    while(entries.hasMoreElements()){
		    	ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		    
		        ExcelReader myReader = new ExcelReader();
		        
		        for(FirstDataSheet value:myReader.getData(stream)) {
		        	
		        	line = value.getTitle() + ",";
		        	System.out.println(line);
		        	
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
