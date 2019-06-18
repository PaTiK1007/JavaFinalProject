package edu.handong.java.data;

import java.util.ArrayList;

public class SecondDataSheet {
	
	private String title;
	private String picNum;
	private String type;
	private String caption;
	private String page;
	
	public SecondDataSheet(ArrayList<String> values) {
		this.title = values.get(0);
		this.picNum = values.get(1);
		this.type = values.get(2);
		this.caption = values.get(3);
		this.page = values.get(4);
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public String getPicNum() {
		return picNum;
	}
	
	public String getType() {
		return type;
	}
	
	public String getCaption() {
		return caption;
	}
	
	public String getPage() {
		return page;
	}
	
}
