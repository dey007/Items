package com.spring.itemsOrder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Items")
public class Items {
	
	@Id
	private String _id;
	
	private String name;
	private double price;
	private int inStock;
	
	public Items() {
		super();
	}

	public Items(String _id, String name, double price, int inStock) {
		super();
		this._id = _id;
		this.name = name;
		this.price = price;
		this.inStock = inStock;
	}




	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	

}
