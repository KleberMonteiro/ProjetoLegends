package com.projeto.service.json.objects.league;

import java.util.List;

public class LeagueDto {

	/** The requested league entries.*/
	private List<LeagueEntryDto> entries;
	private String name;
	private String participantId;
	private String queue;
	private String tier;

	public List<LeagueEntryDto> getEntries() {
		return entries;
	}

	public void setEntries(List<LeagueEntryDto> entries) {
		this.entries = entries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParticipantId() {
		return participantId;
	}

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}
}
