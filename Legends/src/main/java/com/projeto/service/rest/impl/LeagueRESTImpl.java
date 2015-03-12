package com.projeto.service.rest.impl;

import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import com.projeto.service.comum.enums.URLType;
import com.projeto.service.json.objects.league.LeagueDto;

public class LeagueRESTImpl extends GenericRESTImpl{

	public HashMap<String, List<LeagueDto>> searchSummonesrByNames(Integer summonerId) {

		try {		
			
			BufferedReader response = connectionFromServer
				.getResponse(
						MessageFormat
								.format("https://br.api.pvp.net/api/lol/br/v2.5/league/by-summoner/{0}?api_key=b874d81b-2ef2-4554-9bec-7f9c8143906e",
										summonerId.toString()), URLType.GET);
			Type t = new TypeToken<HashMap<String, List<LeagueDto>>>() {}.getType();
			HashMap<String, List<LeagueDto>> summoner = (HashMap<String, List<LeagueDto>>) jsonParser.fromJson(response, t);
	
			return summoner;
			
		} catch (RuntimeException e) {
			System.out.println(e);
		}

		return null;
	}
}
