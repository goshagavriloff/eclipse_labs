package com.baginsky_3istyd_122.lab_5.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import android.content.Context;

public class DatabaseHandler implements InvocationHandler{
	
	 private IManager manager ;
	 private Set<String> _methods=new HashSet<String>();
	 
	 public DatabaseHandler(Context context,Set<String> methods){
		 manager = new DatabaseManager(context);
		 _methods=methods;
	 }
	 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Method open = manager.getClass().getMethod("open");
        Method close = manager.getClass().getMethod("close");
        String methodName=method.getName();
        if (_methods.contains(methodName)) { 
                open.invoke(manager);
                Object returnValue = method.invoke(manager, args);
                close.invoke(manager);

                return returnValue;
            }
        
            return method.invoke(manager);
	}

}
