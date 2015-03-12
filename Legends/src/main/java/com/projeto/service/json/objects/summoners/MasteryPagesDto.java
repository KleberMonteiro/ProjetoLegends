package com.projeto.service.json.objects.summoners;

import java.util.Set;

public class MasteryPagesDto {

	private long summonerId;
	private Set<MasteryPageDto> pages;

	public long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

	public Set<MasteryPageDto> getPages() {
		return pages;
	}

	public void setPages(Set<MasteryPageDto> pages) {
		this.pages = pages;
	}
}
