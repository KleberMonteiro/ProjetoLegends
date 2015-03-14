package com.projeto.service.json.objects.summoners;

import java.util.List;
import java.util.Set;

public class RunePagesDto {

	private long summonerId;
	private List<RunePageDto> pages;

	public long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

	public List<RunePageDto> getPages() {
		return pages;
	}

	public void setPages(List<RunePageDto> pages) {
		this.pages = pages;
	}
}
