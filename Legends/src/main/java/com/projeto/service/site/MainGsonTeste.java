package com.projeto.service.site;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainGsonTeste {

	
	
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().create();
        gson.toJson("Hello", System.out);
        gson.toJson(123, System.out);
        
        
       // gson.fromJson(json, classOfT)
	}
}
