package com.framework.demo;

public class TrimString {

	public static void main(String[] args) {
		String fileName = "\r\n" +  
				"       Hello World!" 
				+ "\r\n";
		
		fileName = fileName.trim();
		System.out.println(fileName);
								  

	}

}
