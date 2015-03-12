package com.projeto.service.rest.impl;

import java.io.BufferedReader;
import java.text.MessageFormat;

import com.projeto.service.comum.enums.URLType;
import com.projeto.service.json.objects.champion.Champion;
import com.projeto.service.json.objects.champion.ChampionsResponse;

public class ChampionRESTImpl extends GenericRESTImpl{
	
	public ChampionsResponse champion(){
		
		BufferedReader response = connectionFromServer.getResponse("https://br.api.pvp.net/api/lol/br/v1.2/champion?api_key=b874d81b-2ef2-4554-9bec-7f9c8143906e", URLType.GET);
		ChampionsResponse champion = jsonParser.fromJson(response, ChampionsResponse.class);
		
		return champion;
	}
	
	public ChampionsResponse champion(Boolean freeToPlay){
		
		BufferedReader response = connectionFromServer.getResponse(MessageFormat.format("https://br.api.pvp.net/api/lol/br/v1.2/champion?freeToPlay={0}&api_key=b874d81b-2ef2-4554-9bec-7f9c8143906e", freeToPlay.toString()), URLType.GET);
		ChampionsResponse champion = jsonParser.fromJson(response, ChampionsResponse.class);
		
		return champion;
	}
	
	public Champion champion(Integer id){
		
		BufferedReader response = connectionFromServer.getResponse(MessageFormat.format("https://br.api.pvp.net/api/lol/br/v1.2/champion/{0}?api_key=b874d81b-2ef2-4554-9bec-7f9c8143906e", id.toString()), URLType.GET);
		Champion champion = jsonParser.fromJson(response, Champion.class);
		
		return champion;
	}
}
