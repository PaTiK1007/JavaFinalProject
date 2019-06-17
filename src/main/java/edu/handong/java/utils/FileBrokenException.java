package edu.handong.java.utils;

public class FileBrokenException extends Exception {

	public FileBrokenException() {
		super ("No CLI argument Exception! Please put a file path.");
	}
		
	public FileBrokenException(String message){
		super (message);
	}
}
