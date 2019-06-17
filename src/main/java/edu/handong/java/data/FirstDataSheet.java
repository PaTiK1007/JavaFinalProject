package edu.handong.java.data;

public class FirstDataSheet {

	

	private String id;
	private String title;
	private String summary;
	private String picNum;
	private String keyword;
	private String date;
	private String domain;
	private String source;
	private String copyright;
	

	public void setId(String val) {
		
		id = val;
	}

	public void setTitle(String val) {
		title=val;
		
	}

	public void setSummary(String val) {
		summary = val;
		
	}

	public void setPicNum(String val) {
		picNum = val;
		
	}

	public void setKeyword(String val) {
		keyword = val;
	}

	public void setDate(String val) {
	
		date = val;
	}

	public void setDomain(String val) {
		
		domain = val;
	}

	public void setSource(String val) {
	
		source = val;
	}

	public void setCopyright(String val) {
		
		copyright = val;
	}

	public String getTitle() {
		return title;
		
	}
	public String getId() {
		return id;
	}

	public String getSummary() {
		return summary;
	}

	public String getPicNum() {
		return picNum;
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
