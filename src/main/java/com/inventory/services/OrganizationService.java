package com.inventory.services;





import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dao.CategoryDao;
import com.inventory.dao.OrganizationDao;
import com.inventory.models.Category;
import com.inventory.models.Organization;




@Service
public class OrganizationService {

	@Autowired
	private  OrganizationDao orgDao;
	
	public  Organization createOrganization(Organization org) {
		return orgDao.save(org);
	}
//
//	public  Iterable<Category> createCategories(List<Category> catList) {
//		Iterable<Category> list = catDao.saveAll(catList);
//		return list;
//	}
	
	public  Iterable<Organization> findAllOrganization() {
		Iterable<Organization> list = orgDao.findAll();
		return list;
	}
	
	public  void deleteOrganization(Organization org) {
		 orgDao.delete(org);
	}

	public Organization getOrganizationInfo(int id) {
			
		Organization org = orgDao.getOne(id);
		return org;
		
	}

	
	@PersistenceContext
    EntityManager entityManager;
    public List<Organization> getOrganizationByName(String name) {
        Query query = entityManager.createNativeQuery("SELECT * FROM sp_inventory.org_tb WHERE name LIKE ?", Organization.class);
        query.setParameter(1, "%"+name + "%");
        return query.getResultList();
    }


}
