package com.projeto.service.json.objects.summoners;

import java.util.Set;

public class RunePagesDto {

	private long summonerId;
	private Set<RunePageDto> pages;

	public long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

	public Set<RunePageDto> getPages() {
		return pages;
	}

	public void setPages(Set<RunePageDto> pages) {
		this.pages = pages;
	}
}
