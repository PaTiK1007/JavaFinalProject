package edu.handong.java.utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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
}
