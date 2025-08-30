package com.baginsky_3istyd_122.lab_2;
public class FutureList extends CalcList{
	private double bufer=Double.NaN;
	
	public FutureList(){
		super();
	}
	@Override
	protected void execute(Calc data) {
		String cursor_value=data.get_value();
		double result=this.getResult();
		
		switch (cursor_value) {
        case "M":
        	result=toogle(result);
            break;
        case "MC":
            bufer=Double.NaN;
            break;
        case "√":
        	result=Math.sqrt(result);
            break;
		}
		if (cursor_value.equals("MC")){
			return;
		} 
		String output=String.valueOf(result);
		Calc calc=new Calc(output,"number");
		Node<Calc> newNode = new Node<Calc>(calc);
		this.head = newNode;
        this.tail = newNode;
        this.size = 1;
	}
	private double toogle(double result){
		double old_value=bufer;
		bufer=(size==1)?result:old_value;
		return bufer;
		
	}
}
