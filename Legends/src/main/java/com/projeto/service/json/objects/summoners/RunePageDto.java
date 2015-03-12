package com.projeto.service.json.objects.summoners;

import java.util.Set;

public class RunePageDto {

	private boolean current;
	private long id;
	private String name;
	private Set<RuneSlotDto> slots;

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RuneSlotDto> getSlots() {
		return slots;
	}

	public void setSlots(Set<RuneSlotDto> slots) {
		this.slots = slots;
	}

}
