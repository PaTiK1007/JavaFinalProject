package edu.handong.java.utils;

public class FileBrokenException extends Exception {

	public FileBrokenException() {
		super ("Error ocurred");
	}
		
	public FileBrokenException(String message){
		super (message);
	}
}
