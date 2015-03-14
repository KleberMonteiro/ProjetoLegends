package com.projeto.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.projeto.service.json.objects.league.LeagueDto;
import com.projeto.service.json.objects.league.LeagueEntryDto;
import com.projeto.service.json.objects.summoners.RunePageDto;
import com.projeto.service.json.objects.summoners.RunePagesDto;
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
	private List<RunePageDto> runePages;
	private Map<Integer, String> imgRunesMap;
	
	@PostConstruct
	public void init() {
		
		imgRunesMap = new HashMap<Integer, String>();
		imgRunesMap.put(5245, "r_1_3.png");
		imgRunesMap.put(5251, "r_3_3.png");
		imgRunesMap.put(5317, "y_1_3.png");
		imgRunesMap.put(5289, "b_3_3.png");
		imgRunesMap.put(5335, "bl_1_3.png");
		imgRunesMap.put(5273, "r_1_3.png");
		imgRunesMap.put(5357, "bl_3_3.png");
		
	}

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
		
		runePages = null;
		
		return Pages.SUMMONER.getPage(); 
	}	
	
	public String abrirRunas() {				
				
		if (runePages == null) {	
			runePages = new ArrayList<RunePageDto>();
			HashMap<String, RunePagesDto> runePagesResponse = new SummonerRESTImpl().searchRunesByIds(summoner.getId());
			
			for (Entry<String, RunePagesDto> entryRunePages : runePagesResponse.entrySet()) {			
				RunePagesDto runePages = entryRunePages.getValue();							
				this.runePages = runePages.getPages();				
			}	    
		}
		
		return Pages.RUNES.getPage(); 
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

	public List<RunePageDto> getRunePages() {
		return runePages;
	}

	public void setRunePages(List<RunePageDto> runePages) {
		this.runePages = runePages;
	}

	public Map<Integer, String> getImgRunesMap() {
		return imgRunesMap;
	}

	public void setImgRunesMap(Map<Integer, String> imgRunesMap) {
		this.imgRunesMap = imgRunesMap;
	}

}