package com.projeto.util.enums;

public enum Pages {
	
	SUMMONER("summoner");
	
	private String page;
	
	Pages(String page) {
		this.page = page;		
	}

	public String getPage() {
		return page;
	}
}
