package com.projeto.service.rest.impl;

import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;
import com.projeto.service.comum.enums.URLType;
import com.projeto.service.json.objects.lolstatus.RuneDto;

public class LolStaticDataRESTImpl extends GenericRESTImpl{

	
	public RuneDto searchRunesById(Integer id) {

		BufferedReader response = connectionFromServer
				.getResponse(
						MessageFormat
								.format("https://global.api.pvp.net/api/lol/static-data/br/v1.2/rune/{0}?runeData=image&api_key=b874d81b-2ef2-4554-9bec-7f9c8143906e",
										id.toString()), URLType.GET);
		
		Type t = new TypeToken<RuneDto>() {}.getType();
		RuneDto runes = (RuneDto) jsonParser.fromJson(response, t);

		return runes;
	}
}
