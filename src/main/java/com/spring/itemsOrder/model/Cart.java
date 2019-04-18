package com.spring.itemsOrder.model;

public class Cart {
	
	private String name;
	private String no;
	private String email;
	
	public Cart() {
		super();
	}
	public Cart(String name, String no, String email) {
		super();
		this.name = name;
		this.no = no;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
