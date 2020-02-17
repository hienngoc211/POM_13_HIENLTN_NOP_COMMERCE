package com.oop.inheritance;

public class Computer {
	//Class cha chứa những thuộc tính và phương thức để miêu tả hoặc set trạng thái
	private String cPU;
	public String monitor;
	protected String keyboard;
	String ram;
	
	public void setCPU(String cpu) {
		cPU = cpu;
	}
	
	public String getCPU() {
		return cPU;
	}
	public void setRam (String ram) {
		this.ram = ram;
	}
	}

