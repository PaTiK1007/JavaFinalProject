package edu.handong.java.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class FileBrokenException extends Exception {

	public FileBrokenException(InputStream is) throws IOException {
		super ("Error ocurred");
		
		FileWriter errorOut = new FileWriter("errorFile.csv");
		CSVPrinter errorPrinter = CSVFormat.DEFAULT.print(errorOut);
		errorPrinter.printRecord(is);
	}
		
	public FileBrokenException(String message){
		super (message);
	}
}
