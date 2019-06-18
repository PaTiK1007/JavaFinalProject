package edu.handong.java.utils;

import java.io.File;
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
			readZip(file.getPath(),file.getName());
		}
		
		writeCSV(output);
		
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
		        
		    
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void writeCSV(String outputPath) throws IOException {
		String firstFileName = "result1.csv";
		String secondFileName = "result2.csv";
		
		
		FileWriter firstOut = new FileWriter(firstFileName);
		CSVPrinter firstPrinter = CSVFormat.DEFAULT
				.withHeader("학번", "제목", "요약문 (300자 내외)", "핵심어(keyword,귐표로 구분)", "조회날짜", "실제자료조회 출처 (웹자료링크)", "원출처 (기관명 등)", "제작자 (Copyright 소유처)").print(firstOut);
		Map<String, ArrayList<FirstDataSheet>> firstDataMap = new TreeMap<String, ArrayList<FirstDataSheet>>(excelReader.getFirstData());
		
		for(String key:firstDataMap.keySet()) {
			for(FirstDataSheet dats:excelReader.getFirstData().get(key)) {
				String title = dats.getTitle();
				String summary = dats.getSummary();
				String keyword = dats.getKeyword();
				String date = dats.getDate();
				String domain = dats.getDomain();
				String source = dats.getSource();
				String copyright = dats.getCopyright();
				firstPrinter.printRecord(key, title, summary, keyword, date, domain, source, copyright);
			}
		}
		
		FileWriter secondOut = new FileWriter(secondFileName);
		CSVPrinter secondPrinter = CSVFormat.DEFAULT
				.withHeader("학번", "제목(반드시 요약문 양식에 입력한 제목과 같아야함.)", "표/그림 일련번호", "자료유형(표,그림,...)", "자료에 나온 표나 그림 설명", "자료가 나온 쪽 번호").print(secondOut);
		
		Map<String, ArrayList<SecondDataSheet>> sortedSecondType = new TreeMap<String, ArrayList<SecondDataSheet>>(excelReader.getSecondData());
		for(String key:sortedSecondType.keySet()) {
			for(SecondDataSheet dats:excelReader.getSecondData().get(key)) {
				String title = dats.getTitle();
				String picNum = dats.getPicNum();
				String Type = dats.getType();
				String caption = dats.getCaption();
				String pageNum = dats.getPage();
				secondPrinter.printRecord(key, title, picNum, Type, caption, pageNum);
			}
		}
	}
	
}

