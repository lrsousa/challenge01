package com.eunumeradores;

public enum BusinessArea {
	RURAL("Rural");
	
	private String area;
	private BusinessArea(String area) {
		this.area = area;
	}
	public String getArea() {
		return area;
	}
}
