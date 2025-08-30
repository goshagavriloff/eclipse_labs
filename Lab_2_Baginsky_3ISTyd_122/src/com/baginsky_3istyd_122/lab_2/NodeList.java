package com.baginsky_3istyd_122.lab_2;

public class NodeList<T> {
	protected Node<T> head;
	protected Node<T> tail; // Optional, for O(1) add to tail
	protected int size;
    
    public NodeList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
 // Method to add an element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    // Method to get the size of the list
    public int size() {
        return size;
    }
    
    // Method to clear of the list
    public void clear() {
    	 this.head = null;
         this.tail = null;
         this.size = 0;
    }

    // Method to display the elements of the list
    public String toString() {
    	String result="";
    	String cursor="";
        Node<T> current = head;
        
        while (current != null) {
        	cursor=getNodeValue(current.data);
        
        	result=String.format("%s%s",result,cursor );
            current = current.next;
        }
        
        return result;
    }
    public String[] toArray(){
    	String[] result=new String[size];
    	String cursor="";
        Node<T> current = head;
        int i=0;
        
        while (current != null) {
        	cursor=getNodeValue(current.data);
        	result[i]=(cursor);
        	i++;
            current = current.next;
        }
        
        return result;
    }
    
    protected String getNodeValue(T data){
    	return data.toString();
    	
    }

}
