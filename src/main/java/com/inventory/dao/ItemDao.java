package com.inventory.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.models.Item;




@Repository
public interface  ItemDao extends JpaRepository<Item, Integer>{

	List<Item> getItemByName(String name);
	
}
