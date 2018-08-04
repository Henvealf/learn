package com.henvealf.learn.designpattern.bridge;

public class StringDisplayImpl extends DisplayImpl{
	private String string;
	private int width;
	
	public StringDisplayImpl(String string) {
		this.string = string;
		this.width = string.getBytes().length;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void rawOpen() {
		// TODO Auto-generated method stub
		printLine();
	}

	@Override
	public void rawPrint() {
		// TODO Auto-generated method stub
		System.out.println("|" + string + "|");
	}

	@Override
	public void rawClose() {
		// TODO Auto-generated method stub
		printLine();
	}
	
	private void printLine(){
		System.out.print("+");
		for(int i = 0; i < width; i++){
			System.out.print("-");
		}
		System.out.println("+");
	}

}
