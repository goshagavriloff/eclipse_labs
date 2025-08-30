package com.baginsky_3istyd_122.lab_5.core;

import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

import android.content.Context;

public class Controller {
	 private IManager dbManager;
	 protected Set<String> _methods;

    public Controller(Context context){
    	setupMethods();
    	
        dbManager = (IManager ) Proxy.newProxyInstance(
        		DatabaseManager.class.getClassLoader(), 
                                   new Class[] {IManager.class}, 
                                   new DatabaseHandler(context,_methods));

    }

    private void setupMethods(){
    	_methods=new HashSet<String>();
    	_methods.add("clear");
		_methods.add("read");
		_methods.add("update");
    }
    
    public IManager getManager(){
		return dbManager;
    }
}
