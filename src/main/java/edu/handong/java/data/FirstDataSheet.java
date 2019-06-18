package edu.handong.java.data;

import java.util.ArrayList;

public class FirstDataSheet {

	
	private String title;
	private String summary;
	private String keyword;
	private String date;
	private String domain;
	private String source;
	private String copyright;
	
	public FirstDataSheet(ArrayList<String> values) {
		this.title = values.get(0);
		this.summary = values.get(1);
		this.keyword = values.get(2);
		this.date = values.get(3);
		this.domain = values.get(4);
		this.source = values.get(5);
		this.copyright = values.get(6);
	}

	public String getTitle() {
		return title;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public String getSource() {
		return source;
	}
	
	public String getCopyright() {
		return copyright;
	}
	

}
