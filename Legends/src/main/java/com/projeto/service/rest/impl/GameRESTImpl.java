package com.projeto.service.rest.impl;

import java.io.BufferedReader;
import java.text.MessageFormat;

import com.projeto.service.comum.enums.URLType;
import com.projeto.service.json.objects.champion.ChampionsResponse;

public class GameRESTImpl extends GenericRESTImpl{

	
	public void recent (Integer summonerId){
		
		BufferedReader response = connectionFromServer.getResponse(MessageFormat.format("https://br.api.pvp.net/api/lol/br/v1.3/game/by-summoner/{0}/recent?api_key=b874d81b-2ef2-4554-9bec-7f9c8143906e",summonerId.toString()), URLType.GET);
		ChampionsResponse champion = jsonParser.fromJson(response, ChampionsResponse.class);
		
//		return champion;
	}
	
}
