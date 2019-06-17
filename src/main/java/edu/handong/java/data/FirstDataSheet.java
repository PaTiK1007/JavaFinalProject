package edu.handong.java.data;

import java.util.ArrayList;

public class FirstDataSheet {

	

	private String id;
	private String title;
	private String summary;
	private String keyword;
	private String date;
	private String domain;
	private String source;
	private String copyright;
	
	public FirstDataSheet(ArrayList<String> values) {
		this.id = values.get(0);
		this.title = values.get(1);
		this.summary = values.get(2);
		this.keyword = values.get(3);
		this.date = values.get(4);
		this.domain = values.get(5);
		this.source = values.get(6);
		this.copyright = values.get(7);
	}
	
	
	public String getId() {
		return id;
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
