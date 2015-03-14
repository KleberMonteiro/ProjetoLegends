package com.projeto.service.rest.impl;

import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.projeto.service.comum.enums.URLType;
import com.projeto.service.json.objects.summoners.MasteryPagesDto;
import com.projeto.service.json.objects.summoners.RunePagesDto;
import com.projeto.service.json.objects.summoners.SummonerDto;

public class SummonerRESTImpl extends GenericRESTImpl {

	public HashMap<String, SummonerDto> searchSummonesrByNames(String summonerName) {

		BufferedReader response = connectionFromServer
				.getResponse(
						MessageFormat
								.format("https://br.api.pvp.net/api/lol/br/v1.4/summoner/by-name/{0}?api_key=b874d81b-2ef2-4554-9bec-7f9c8143906e",
										summonerName.replace(" ", "%20")), URLType.GET);
				
		Type t = new TypeToken<HashMap<String, SummonerDto>>() {}.getType();
		HashMap<String, SummonerDto> summoner = (HashMap<String, SummonerDto>) jsonParser.fromJson(response, t);

		return summoner;
	}
		
	public HashMap<String, SummonerDto> searchSummonersByIds(Integer ids) {

		BufferedReader response = connectionFromServer.getResponse(MessageFormat.format(
				"https://br.api.pvp.net/api/lol/br/v1.4/summoner/{0}?api_key=b874d81b-2ef2-4554-9bec-7f9c8143906e",
				ids.toString()), URLType.GET);

		Map<String, SummonerDto> map = new HashMap<String, SummonerDto>();
		HashMap<String, SummonerDto> summoner = (HashMap<String, SummonerDto>) jsonParser.fromJson(response, map.getClass());

		return summoner;
	}

	public HashMap<String, MasteryPagesDto> searchMasteriesByIds(Integer ids) {

		BufferedReader response = connectionFromServer
				.getResponse(
						MessageFormat
								.format("https://br.api.pvp.net/api/lol/br/v1.4/summoner/{0}/masteries?api_key=b874d81b-2ef2-4554-9bec-7f9c8143906e",
										ids.toString()), URLType.GET);

		Map<String, MasteryPagesDto> map = new HashMap<String, MasteryPagesDto>();
		HashMap<String, MasteryPagesDto> summoner = (HashMap<String, MasteryPagesDto>) jsonParser.fromJson(response, map.getClass());

		return summoner;
	}

	public HashMap<String, String> searchNamesByIds(Integer ids) {

		BufferedReader response = connectionFromServer
				.getResponse(
						MessageFormat
								.format("https://br.api.pvp.net/api/lol/br/v1.4/summoner/{0}/name?api_key=b874d81b-2ef2-4554-9bec-7f9c8143906e",
										ids.toString()), URLType.GET);

		Map<String, String> map = new HashMap<String, String>();
		HashMap<String, String> summoner = (HashMap<String, String>) jsonParser.fromJson(response, map.getClass());

		return summoner;
	}

	public HashMap<String, RunePagesDto> searchRunesByIds(Integer ids) {

		BufferedReader response = connectionFromServer
				.getResponse(
						MessageFormat
								.format("https://br.api.pvp.net/api/lol/br/v1.4/summoner/{0}/runes?api_key=b874d81b-2ef2-4554-9bec-7f9c8143906e",
										ids.toString()), URLType.GET);
		
//		Map<String, RunePagesDto> map = new HashMap<String, RunePagesDto>();		
		Type t = new TypeToken<HashMap<String, RunePagesDto>>() {}.getType();
		HashMap<String, RunePagesDto> summoner = (HashMap<String, RunePagesDto>) jsonParser.fromJson(response, t);

		return summoner;
	}
}
