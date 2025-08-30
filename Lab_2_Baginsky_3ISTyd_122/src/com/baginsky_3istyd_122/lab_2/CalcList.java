package com.baginsky_3istyd_122.lab_2;

import java.util.List;




public class CalcList extends NodeList<Calc>{
    
    public CalcList() {
    	super();
    }

	@Override
	protected String getNodeValue(Calc data) {
		return data.get_value();
	};
    
    
    public void update(Calc data){
    	if (isInvalid(data)){
    		return;
    	}
    	
    	if (size==0){
    		this.add(data);
    		return;
    	}
    	this.render(data);
    }
    
    private void render(Calc data){
    	String cursor_tag=data.get_tag();
    	String tail_tag=tail.data.get_tag();

    	boolean isNumber=cursor_tag.equals("number") && cursor_tag.equals(tail_tag);
    	boolean isExecute=cursor_tag.equals("execute");
    	
    	if (isNumber){
    		this.addNumber(data);
    		return;
    	}
    	
    	if (isExecute){
	        this.execute(data);
	        return;
    	}
    	

    	
    	this.add(data);
    	
    }
    
    
    
    private boolean isInvalid(Calc data){
    	boolean result=false;
    	String cursor_tag=data.get_tag();
    	String cursor_value=data.get_value();	
    	
    	boolean isOperation=cursor_tag.equals("operation");
    	boolean isOrder=size==0 && isOperation;
    	
    	if (size==0){
    		return isOrder;
    	}
    	
    	String tail_tag=tail.data.get_tag();	
    	String tail_value=tail.data.get_value();	
    	
   
    	boolean isInvalidOperation=isOperation&&cursor_tag.equals(tail_tag);
    	boolean isInvalidDot=tail_value.contains(".")&&cursor_value.equals(".");

    	
    	return result || isInvalidOperation || isOrder || isInvalidDot;
    }


    protected void addNumber(Calc data){
    	String _value=String.format("%s%s", tail.data.get_value(),data.get_value());
		tail.data.set_value(_value);
    }
    
    protected void execute(Calc data){
		double result=this.getResult();
		
		Calc calc=new Calc(String.valueOf(result),"number");
		Node<Calc> newNode = new Node<Calc>(calc);
		
		this.head = newNode;
        this.tail = newNode;
        this.size = 1;
    }
    
    protected double getResult(){
    	Calculator calculator=new Calculator();
		List<String> pn=calculator.convertToPN(this);
		String[] tokens = pn.toArray(new String[0]);
		
		return calculator.evalPN(tokens);
		
		
    }
    
}
