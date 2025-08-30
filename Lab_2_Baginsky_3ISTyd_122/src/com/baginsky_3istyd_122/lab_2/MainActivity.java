package com.baginsky_3istyd_122.lab_2;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainActivity extends CalcActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupCalculator();
    }
    
    public void setupCalculator(){
    	ArrayList<Button> buttons=getButtons();
    	for (Button button : buttons) {
    		
    		setupButton(button);
    		
		}
    }
    
    public ArrayList<Button> getButtons() {
        ArrayList<Button> buttons = new ArrayList<Button>();
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        findButtons(viewGroup, buttons);
        return buttons;
    }

    private static void findButtons(ViewGroup viewGroup,ArrayList<Button> buttons) {
        for (int i = 0, N = viewGroup.getChildCount(); i < N; i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                findButtons((ViewGroup) child, buttons);
            } else if (child instanceof Button) {
                buttons.add((Button) child);
            }
        }
    }
}
