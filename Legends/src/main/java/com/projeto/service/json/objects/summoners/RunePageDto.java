package com.projeto.service.json.objects.summoners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunePageDto {

	private boolean current;
	private long id;
	private String name;
	private List<RuneSlotDto> slots;
	
	public Map<Integer, Integer> getGruppedRunes() {
		Map<Integer, Integer> runesMap = new HashMap<Integer, Integer>();
		
		for (RuneSlotDto slot : slots) {
			if (runesMap.containsKey(slot.getRuneId())) {
				runesMap.put(slot.getRuneId(), runesMap.get(slot.getRuneId()) + 1);
			} else {
				runesMap.put(slot.getRuneId(), 1);
			}
		}
		
		return runesMap;
	}
	
	public List<Integer> getRunes() {
		return new ArrayList<Integer>(getGruppedRunes().keySet());
	}
	
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

	public List<RuneSlotDto> getSlots() {
		return slots;
	}

	public void setSlots(List<RuneSlotDto> slots) {		
		this.slots = slots;
	}

}
