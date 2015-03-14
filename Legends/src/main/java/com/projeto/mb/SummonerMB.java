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
import com.projeto.service.json.objects.summoners.MasteryDto;
import com.projeto.service.json.objects.summoners.MasteryPageDto;
import com.projeto.service.json.objects.summoners.MasteryPagesDto;
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
	private List<MasteryPageDto> masteryPages;
	private Map<Long, Map<Integer, MasteryDto>> masteryPagesMap;
	private Long selectedMasteryPage;
	
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
		imgRunesMap.put(5337, "bl_3_3.png");
		imgRunesMap.put(5297, "b_3_3.png");
		imgRunesMap.put(5295, "b_1_3.png");
		imgRunesMap.put(5365, "bl_3_3.png");
		imgRunesMap.put(5418, "bl_4_3.png");
		imgRunesMap.put(5412, "bl_1_3.png");
		imgRunesMap.put(5402, "r_1_3.png");
		imgRunesMap.put(5247, "r_3_3.png");
		imgRunesMap.put(5257, "r_1_3.png");
		imgRunesMap.put(5316, "y_4_3.png");
		imgRunesMap.put(5345, "bl_3_3.png");
		imgRunesMap.put(5355, "bl_1_3.png");
		imgRunesMap.put(5367, "bl_4_3.png");
		imgRunesMap.put(5331, "y_3_3.png");
		imgRunesMap.put(5213, "bl_1_2.png");
		
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
		masteryPagesMap = null;
		
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
	
	public String abrirTalentos() {				
		
		if (masteryPagesMap == null) {
			masteryPages = new ArrayList<MasteryPageDto>();
			masteryPagesMap = new HashMap<Long, Map<Integer,MasteryDto>>();
			HashMap<String, MasteryPagesDto> masteriesResponse = new SummonerRESTImpl().searchMasteriesByIds(summoner.getId());
			
			for (Entry<String, MasteryPagesDto> entryRunePages : masteriesResponse.entrySet()) {			
				MasteryPagesDto masteriePages = entryRunePages.getValue();							
				Map<Integer,MasteryDto> masteriesMap = null;
				
				for (MasteryPageDto masteriePage : masteriePages.getPages()) {
					masteryPages.add(masteriePage);
					masteriesMap = new HashMap<Integer, MasteryDto>();
					
					if (masteriePage.getMasteries() != null) {
						for (MasteryDto mastery : masteriePage.getMasteries()) {
							masteriesMap.put(mastery.getId(), mastery);
						}
						
						masteryPagesMap.put(masteriePage.getId(), masteriesMap); 
					}
				}	
				
				selectedMasteryPage = masteryPages.get(0).getId();
			}
		}			
		
		return Pages.MASTERIES.getPage(); 
	}
	
	public boolean containsMastery(Long idPage, Integer idMastery) {
		boolean exists = false;
		
		if (masteryPagesMap.containsKey(idPage)) {
			exists = masteryPagesMap.get(idPage).containsKey(idMastery);
		}
		
		return exists;
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

	public String getTier() {
		return tier;
	}

	public String getDivision() {
		return division;
	}

	public String getUrlTierImage() {
		return urlTierImage;
	}

	public List<RunePageDto> getRunePages() {
		return runePages;
	}

	public Map<Integer, String> getImgRunesMap() {
		return imgRunesMap;
	}

	public List<MasteryPageDto> getMasteryPages() {
		return masteryPages;
	}

	public Map<Long, Map<Integer, MasteryDto>> getMasteryPagesMap() {
		return masteryPagesMap;
	}

	public Long getSelectedMasteryPage() {
		return selectedMasteryPage;
	}

	public void setSelectedMasteryPage(Long selectedMasteryPage) {
		this.selectedMasteryPage = selectedMasteryPage;
	}

	
}