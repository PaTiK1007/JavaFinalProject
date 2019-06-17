package edu.handong.java.utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import edu.handong.java.data.FirstDataSheet;
import edu.handong.java.data.SecondDataSheet;

public class ResultPrinter {

	public static void writeAFile (ArrayList<String> lines, String targetFileName) {
		try {
	         File fp= new File(targetFileName);
	         FileOutputStream fos = new FileOutputStream(fp);
	         DataOutputStream dos =new DataOutputStream(fos);
	         
	         for(String line:lines){
	            dos.write((line+"\n").getBytes());	
	         }
	         dos.close();
	         fos.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } 
		System.out.println("complete");
	   }
	
	public static void iniCSV(String outputPath) throws IOException {
		
		private static ExcelReader myReader = new ExcelReader();
		Map<String, ArrayList<FirstDataSheet>> sortedFirstType = new TreeMap<String, ArrayList<SecondDataSheet>>(myReader.getFirstType());
		
		String firstFile = "Result1.csv";
		String secondFile = "Result2.csv";
		
		FileWriter firstOut = new FileWriter(firstFile);
		CSVPrinter firstPrinter = CSVFormat
				.DEFAULT.withHeader("학번", "제목", "요약문 (300자 내외)", "핵심어(keyword,귐표로 구분)", "조회날짜", "실제자료조회 출처 (웹자료링크)", "원출처 (기관명 등)", "제작자 (Copyright 소유처)").print(firstOut);
}
}
