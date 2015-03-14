package com.projeto.service.json.objects.lolstatus;

public class RuneDto {
	
	private String id;
	private String description;
	private String name;
	private ImageDto image;
	private MetaDataDto rune;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ImageDto getImage() {
		return image;
	}
	public void setImage(ImageDto image) {
		this.image = image;
	}
	public MetaDataDto getRune() {
		return rune;
	}
	public void setRune(MetaDataDto rune) {
		this.rune = rune;
	}

}
