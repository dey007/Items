package com.spring.itemsOrder.service;

import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.stereotype.Service;

import com.spring.itemsOrder.exception.OutOfStockException;
import com.spring.itemsOrder.model.Cart;
import com.spring.itemsOrder.model.Items;
import com.spring.itemsOrder.repo.ItemReposityory;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	// private ItemReposityory repository;
	private MongoOperations repository;

	@Override
	public List<Items> getItems() {

		return repository.findAll(Items.class);
	}

	@Override
	public void createItem(Items item) {
		repository.insert(item);
	}

	@Override
	public double makeOrder(List<Cart> cart) {
		double totalAmount = 0;
		int inStock = 0;
		List<Items> itemRepo =	repository.findAll(Items.class);
		for(Items item : itemRepo) { 
			if(item.getInStock()>0) {
				for(int i=0; i<cart.size(); i++) {
					if(item.getName().equalsIgnoreCase(cart.get(i).getName().toString())) { 
						int no = Integer.parseInt(cart.get(i).getNo());
						inStock = item.getInStock() - no;
						repository.updateFirst(query(Criteria.where("_id").is(item.get_id())), Update.update("inStock", inStock), "Items");
						totalAmount = totalAmount + (item.getPrice()*no);
						break;
					}
				  
				}
			}
			else {
				throw new OutOfStockException("Item is out of Stock");
			}
		}
		return totalAmount;
	}
}