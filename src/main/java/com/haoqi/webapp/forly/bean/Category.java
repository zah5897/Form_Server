package com.haoqi.webapp.forly.bean;

public enum Category {
	FUNNY(10,"内涵段子"),FORLY(11,"福利"),GIT(12,"求出处"),SECRET(13,"我的私密");	
	private int _value;
	private String _text;

	private Category(int value, String text) {
		this._text = text;
		this._value = value;
	}
	public int getValue() {
		return _value;
	}
}
