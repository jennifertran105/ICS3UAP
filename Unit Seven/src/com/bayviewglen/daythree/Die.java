package com.bayviewglen.daythree;

public class Die {
	private int numSides;
	private int top;
	
	
	public  Die(){
		numSides = 6;
		roll();
		
	}
	public Die(int numSides){
		this.numSides = numSides;
		roll();
	}
	 
	public int getTop(){
		return top;
		
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getNumSides() {
		return numSides;
	}
	public String toString(){
		return "" + getTop();
	}
	public void roll(){
		top = (int)(Math.random() * numSides) + 1;
	}
}
