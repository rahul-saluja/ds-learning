package com.tree;

public class Test {

	public static void main(String[] args) {
		System.out.println(Math.subtractExact(-1, -1));
		String testString= "Hello";
		Test t = new Test();
		t.testmethod(testString);
		System.out.println("back in main "+ testString);
	}
	
	
	
	public void testmethod(String a ){
		System.out.println(a);
		a = "bye";
		System.out.println(a);
	}
}
