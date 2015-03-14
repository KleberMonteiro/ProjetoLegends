package com.projeto.util.enums;

public enum Pages {
	
	SUMMONER("summoner"), 
	RUNES("runes");;
	
	private String page;
	
	Pages(String page) {
		this.page = page;		
	}

	public String getPage() {
		return page;
	}
}
