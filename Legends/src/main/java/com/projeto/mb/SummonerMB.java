package com.projeto.mb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.projeto.service.json.objects.league.LeagueDto;
import com.projeto.service.json.objects.league.LeagueEntryDto;
import com.projeto.service.json.objects.summoners.SummonerDto;
import com.projeto.service.rest.impl.LeagueRESTImpl;
import com.projeto.service.rest.impl.SummonerRESTImpl;
import com.projeto.util.enums.Pages;

@ManagedBean
@SessionScoped
public class SummonerMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private SummonerDto summoner;	
	private String name;
	private String tier;
	private String division;
	private String urlTierImage;

	public String buscar() {
		HashMap<String, SummonerDto> summonerResponse = new SummonerRESTImpl().searchSummonesrByNames(name);
		
		for (Entry<String, SummonerDto> entrySummoner : summonerResponse.entrySet()) {			
			summoner = entrySummoner.getValue();
		}
		
		HashMap<String, List<LeagueDto>> leagueResponse = new LeagueRESTImpl().searchSummonesrByNames(summoner.getId());
		
		if (leagueResponse != null) {		
			for (Entry<String, List<LeagueDto>> entryLeague : leagueResponse.entrySet()) {		
				for (LeagueDto league : entryLeague.getValue()) {	
					tier = league.getTier();
					
					for (LeagueEntryDto entry : league.getEntries()) {
						if (entry.getPlayerOrTeamId().equals(String.valueOf(summoner.getId()))){
							division = entry.getDivision();
							break;
						}
					}
				}
			}
			
			urlTierImage = "resources/images/leagues/" + tier.toLowerCase() + "_" + division + ".png";
		} else {
			urlTierImage = "resources/images/leagues/default.png";
		}
		
		return Pages.SUMMONER.getPage(); 
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;				
	}

	public SummonerDto getSummoner() {
		return summoner;
	}

	public void setSummoner(SummonerDto summoner) {
		this.summoner = summoner;
	}

	public String getUrlTierImage() {
		return urlTierImage;
	}

	public void setUrlTierImage(String urlTierImage) {
		this.urlTierImage = urlTierImage;
	}

}