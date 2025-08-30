package com.baginsky_3istyd_122.lab_5.core;

import java.util.ArrayList;

import android.content.ContentValues;

public interface IManager {
	void open();
	void close();
	
	
	void clear();
	long update(ContentValues data);
	ArrayList<String> read();
	
	
	void clear(ContentValues data);
	ArrayList<String> read(ContentValues data);
	
}
