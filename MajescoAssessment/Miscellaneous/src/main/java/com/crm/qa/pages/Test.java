package com.crm.qa.pages;

public class Test {
	
	int p,q;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test t=new Test();
		Test t1=new Test();
		
		  int a,b;
              a=10;
            		  b=20;
		t.swap(a,b);
	        System.out.println("Main Method p ="+a);
		System.out.println("Main Method q="+b);
		

	}

	public void swap(int a, int b) {
		int temp;
		temp=a;
		a=b;
        b=temp;
		System.out.println("Swap Method p ="+a);
		System.out.println("Swap Method  q="+b);

	
	}
	public void add(int a) {}
	public void add(double a) {}
	public void add(double a,int b) {}
	public void add() {}
	
	
}
