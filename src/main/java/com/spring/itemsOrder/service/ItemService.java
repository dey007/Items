package com.spring.itemsOrder.service;

import java.util.List;
import java.util.Map;

import com.spring.itemsOrder.model.Cart;
import com.spring.itemsOrder.model.Items;

public interface ItemService {

	public List<Items> getItems();
	public void createItem(Items item);
	public double makeOrder(List<Cart> cart);
}
