package com.baginsky_3istyd_122.lab_2;

import java.util.List;


public class Calculator {
   
    public Double evalPN(String[] tokens) {
        return PolishNotation.evaluatePolishNotation(tokens);
    }

	public List<String> convertToPN(CalcList list) {
		String[] expression=list.toArray();
		return PolishNotation.convertToPolishNotation(expression);
	}


}


