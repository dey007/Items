package com.spring.itemsOrder.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.itemsOrder.model.Cart;
import com.spring.itemsOrder.model.Items;
import com.spring.itemsOrder.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	public ItemService getItemService() {
		return itemService;
	}
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping("/items")
	public ResponseEntity<List<Items>> getItems(){
		List<Items> items = itemService.getItems();
		if(items.isEmpty()) {
			return new ResponseEntity<List<Items>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Items>>(items, HttpStatus.OK);
		
	}
	
	@PostMapping("/items/create")
	public void createItem(@RequestBody Items item) {
		 itemService.createItem(item);
	}

	@PostMapping("/items/order")
	public double ItemsToOrder(@RequestBody List<Cart> cart) {
		return itemService.makeOrder(cart);
	}
}
