package com.course.consumingrest.model;
public enum Tag {
	GENERAL("general"),
	SPORT("sport"),
	ECONOMY("economy"),
	TECHNOLOGY("technology");
	private String tag;
	private Tag(String tag) {
		this.tag = tag;
	}
	public String getTag() {
		return tag;
	}
}