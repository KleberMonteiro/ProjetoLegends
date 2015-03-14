package com.projeto.service.site;

import java.util.HashMap;
import java.util.Map.Entry;

import com.projeto.service.json.objects.summoners.MasteryPagesDto;
import com.projeto.service.json.objects.summoners.SummonerDto;
import com.projeto.service.rest.impl.SummonerRESTImpl;

public class TesteRESTCliente {

	public static void main(String[] args) {
		HashMap<String, SummonerDto> summonerResponse = new SummonerRESTImpl().searchSummonesrByNames("Acellor Mittal");				
		
		for (Entry<String, SummonerDto> entrySummoner : summonerResponse.entrySet()) {			
			SummonerDto summoner = entrySummoner.getValue();	
			
			HashMap<String, MasteryPagesDto> masteriesResponse = new SummonerRESTImpl().searchMasteriesByIds(summoner.getId());
			System.out.println(masteriesResponse);
			
//			HashMap<String, RunePagesDto> runePagesResponse = new SummonerRESTImpl().searchRunesByIds(summoner.getId());
//			
//			for (Entry<String, RunePagesDto> entryRunePages : runePagesResponse.entrySet()) {			
//				RunePagesDto runePages = entryRunePages.getValue();
//				
//				for (RunePageDto runePage : runePages.getPages()) {					
//					System.out.println(runePage.getName());
//					
//					for (RuneSlotDto runeSlot : runePage.getSlots()) {
//						System.out.println("Slot " + runeSlot.getRuneSlotId() + ": " + runeSlot.getRuneId());
//					}
//				}
//			}	    
		}	
		
//		HashMap<String, List<LeagueDto>> teste = new LeagueRESTImpl().searchSummonesrByNames(551793);
//		for (Entry<String, List<LeagueDto>> t : teste.entrySet()) {		
//			for (LeagueDto l : t.getValue()) {
//				for ( LeagueEntryDto le : l.getEntries()) {
//					System.out.println(le.getPlayerOrTeamName());
//				}
//			}
//		}
	}
}
