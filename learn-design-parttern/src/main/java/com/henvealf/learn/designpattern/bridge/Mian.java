package com.henvealf.learn.designpattern.bridge;

public class Mian {
	public static void main(String[] args) {
		Display dl = new Display(new StringDisplayImpl("heekdfklefje"));
		Display d2 = new Display(new StringDisplayImpl("adadadads"));
		CountDisplay d3 = new CountDisplay(new StringDisplayImpl("sdjsadhsajkdasjkdajsksdhsa"));
		dl.diaplay();
		d2.diaplay();
		d3.diaplay();
		d3.mutiDiaplay(4);
	}
}
