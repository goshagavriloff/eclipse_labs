package com.baginsky_3istyd_122.lab_2;

public class Calc {
	private String _value;
	private String _tag;
	
	public Calc (String value,String tag){ 
		set_value(value);
		setTag(tag);
		
	}
	
	public void setTag(String tag) {
		this._tag = tag;
	}

	public void set_value(String _value) {
		this._value = _value;
	}
	
	public String get_value() {
		return _value;
	}
	
	public String get_tag() {
		return _tag;
	}


}
