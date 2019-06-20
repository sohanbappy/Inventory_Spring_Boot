package com.inventory.services;





import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dao.ItemDao;
import com.inventory.dao.SellDao;
import com.inventory.models.Sell;






@Service
public class SellService{

	@Autowired
	private  ItemDao itemDao;
	@Autowired
	private  SellDao sellDao;
	
	public  Sell createSell(Sell sell) {
		return sellDao.save(sell);
	}

	public  Iterable<Sell> createSells(List<Sell> sellList) {
		Iterable<Sell> list = sellDao.saveAll(sellList);
		return list;
	}
	
	public  Iterable<Sell> findAllSells() {
		Iterable<Sell> list = sellDao.findAll();
		return list;
	}
	
	
	public  void deleteSell(Sell sell) {
		 sellDao.delete(sell);
	}

	public Sell getSellInfo(int id) {
			
		Sell sell = sellDao.getOne(id);
		return sell;
		
	}
	
	@PersistenceContext
    EntityManager entityManager;
	public List<Sell> getSellByInvoice(String inv_no) {
        Query query = entityManager.createNativeQuery("SELECT * FROM sp_inventory.sell_tb WHERE inv_no LIKE ?", Sell.class);
        query.setParameter(1, inv_no + "%");
        return query.getResultList();
    }



	


}
