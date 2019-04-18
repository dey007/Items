package com.spring.itemsOrder.repo;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.itemsOrder.model.Items;

@Repository
@Transactional
public interface ItemReposityory extends MongoOperations {

}
