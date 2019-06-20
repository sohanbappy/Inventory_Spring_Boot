package com.inventory.services;





import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.inventory.dao.CategoryDao;
import com.inventory.models.Category;




@Service
public class CategoryService {

	@Autowired
	private  CategoryDao catDao;
	
	public  Category createCategory(Category cat) {
		return catDao.save(cat);
	}

	public  Iterable<Category> createCategories(List<Category> catList) {
		Iterable<Category> list = catDao.saveAll(catList);
		return list;
	}
	
	public  Iterable<Category> findAllCat() {
		Iterable<Category> list = catDao.findAll();
		return list;
	}
	
	public  Iterable<Category> findAllCatPagination(int page) {
		Iterable<Category> list = catDao.findAll(new PageRequest(page,5));
		return list;
	}
	
	public  void deleteCategory(Category cat) {
		 catDao.delete(cat);
	}

	public Category getCategoryInfo(int id) {
			
		Category cat = catDao.getOne(id);
		return cat;
		
	}
	
	@PersistenceContext
    EntityManager entityManager;
    public List<Category> getCategoryByName(String name) {
        Query query = entityManager.createNativeQuery("SELECT * FROM sp_inventory.category_tb WHERE name LIKE ?", Category.class);
        query.setParameter(1, name + "%");
        return query.getResultList();
    }
	
	
	


}
