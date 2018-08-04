package com.henvealf.learn.designpattern.bridge.test;

public class CountDisplay extends Display{

	private static int time = 0;
	public CountDisplay(DisplayImpl impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	public void countDisplay(){
		start();
		for(int i = 0; i< time; i++)
			middle();
		time++;
		end();
	}

}
