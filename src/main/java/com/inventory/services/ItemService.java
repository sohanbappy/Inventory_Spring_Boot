package com.inventory.services;





import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dao.ItemDao;
import com.inventory.models.Item;






@Service
public class ItemService {

	@Autowired
	private  ItemDao itemDao;
	
	public  Item createItem(Item item) {
		return itemDao.save(item);
	}

	public  Iterable<Item> createItems(List<Item> itemList) {
		Iterable<Item> list = itemDao.saveAll(itemList);
		return list;
	}
	
	public  Iterable<Item> findAllItems() {
		Iterable<Item> list = itemDao.findAll();
		return list;
	}
	
	
	public  void deleteItem(Item item) {
		 itemDao.delete(item);
	}

	public Item getItemInfo(int id) {
			
		Item item = itemDao.getOne(id);
		return item;
		
	}
	
	@PersistenceContext
    EntityManager entityManager;
    public List<Item> getItemByName(String name) {
        Query query = entityManager.createNativeQuery("SELECT * FROM sp_inventory.item_tb WHERE name LIKE ?", Item.class);
        query.setParameter(1, name + "%");
        return query.getResultList();
    }
	
	
	


}
