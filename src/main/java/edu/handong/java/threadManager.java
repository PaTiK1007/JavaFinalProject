package edu.handong.java;

import edu.handong.java.utils.ZipReader;

public class threadManager implements Runnable {

	private String path;
	private String studentID;
	
	public threadManager(String pathName, String idOfStudent) {
		this.path= pathName;
		this.studentID = idOfStudent;
	}
	
	@Override
	public void run() {
		
		System.out.println("Hello from a thread!");
		ZipReader.readZip(path,studentID);
		
	}

}
