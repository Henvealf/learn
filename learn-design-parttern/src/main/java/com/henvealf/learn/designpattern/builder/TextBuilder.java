package com.henvealf.learn.designpattern.builder;

public class TextBuilder extends Builder{
	private StringBuffer buffer  = new StringBuffer();
	@Override
	public void makeTitle(String title) {
		// TODO Auto-generated method stub
		buffer.append("===================\n");
		buffer.append(title);
		buffer.append("\n");
	}

	@Override
	public void makeString(String str) {
		// TODO Auto-generated method stub
		buffer.append(str);
		buffer.append("\n");
	}

	@Override
	public void makeItems(String[] items) {
		// TODO Auto-generated method stub
		for(int i = 0; i <items.length;i++){
			buffer.append(items[i]);
		}
		buffer.append("\n");
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		buffer.append("=================\n");
		return buffer.toString();
	}
	
}
