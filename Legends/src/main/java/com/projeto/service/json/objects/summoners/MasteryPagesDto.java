package com.projeto.service.json.objects.summoners;

import java.util.List;

public class MasteryPagesDto {

	private long summonerId;
	private List<MasteryPageDto> pages;

	public long getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(long summonerId) {
		this.summonerId = summonerId;
	}

	public List<MasteryPageDto> getPages() {
		return pages;
	}

	public void setPages(List<MasteryPageDto> pages) {
		this.pages = pages;
	}
}
