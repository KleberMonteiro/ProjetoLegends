package com.projeto.service.comum.enums;

public enum URLType {

	GET("GET"),
	POST("POST");
	
   private String key;
	
	private URLType(String key){
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
