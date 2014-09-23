package com.cloud.clinic.model;

/*
 * 
 * Just a helper class for Pair
 * 
 */

public class Pair<A, B> {
	private A a;
	private B b;
	
	public Pair(A a, B b){
		super();
		this.a = a;
		this.b = b;
	}
	
	public A getFirst(){
		return a;
	}
	
	public B getSecond(){
		return b;
	}
	
	public void setFirst(A a){
		this.a = a;
	}
	
	public void setSecond(B b){
		this.b = b;
	}
}
