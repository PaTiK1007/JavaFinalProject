package edu.handong.java.data;

import java.util.ArrayList;

public class SecondDataSheet {
	
	private String id;
	private String title;
	private String picNum;
	private String type;
	private String caption;
	private String page;
	
	public SecondDataSheet(ArrayList<String> values) {
		this.id = values.get(0);
		this.title = values.get(1);
		this.picNum = values.get(2);
		this.type = values.get(3);
		this.caption = values.get(4);
		this.page = values.get(5);
	}
	
	
	
	public String getId() {
		return id;
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
