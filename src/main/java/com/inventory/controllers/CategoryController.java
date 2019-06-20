package com.inventory.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.inventory.dao.CategoryDao;
import com.inventory.models.Category;
import com.inventory.models.Organization;
import com.inventory.services.CategoryService;
import com.inventory.services.OrganizationService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService catService;
	@Autowired
	OrganizationService orgService;
	
	
	
	
	@Autowired
	private  CategoryDao catDao;
	
	@RequestMapping(value="/getCats",method=RequestMethod.GET)
	@ResponseBody
	public String getCategoris(){
		Gson json = new Gson();
		return json.toJson(catDao.findAll());
	}
	
	 
	@RequestMapping(value="/manageCategory",method=RequestMethod.GET)
	public ModelAndView getManageCategory() {
		
		ModelAndView mp =new ModelAndView("manageCategory");
		
		List<Category> catList =  catDao.findAll();
		System.out.print(catList);
		mp.addObject("catList", catList);
		return mp;
	}
	
	
	@RequestMapping(value="/addCat",method=RequestMethod.GET)
	public ModelAndView addCategory() {
		
        ModelAndView mp =new ModelAndView("addCat");
        Iterable<Organization> orgList = orgService.findAllOrganization();
		mp.addObject("orgList",orgList);
		
		return mp;
	}
	
	@RequestMapping(value="/addCat",method=RequestMethod.POST)
	public ModelAndView addCategoryInfo(@RequestParam("cat_name") String name,@RequestParam("org_id") String org_id) {
		
		Category category = new Category();
		category.setName(name);
		category.setOrg_id(org_id);
		category.setCreation_date(new Date());
		
		Category cat = catService.createCategory(category);
		ModelAndView mp =new ModelAndView("catSuccess");
		
		mp.addObject("cat",cat);
		mp.addObject("msg", "Category added successfully!!!!!");
		
	
		
		
		
		return mp;
	}
	

	
	@RequestMapping(value="/searchCat",method=RequestMethod.POST)
	public ModelAndView searchCategoryInfo(@RequestParam("name") String name) {
		
		List<Category> catList = catService.getCategoryByName(name);
		
		ModelAndView mp =new ModelAndView("manageCategory");
		mp.addObject("catList",catList);
		
		
		return mp;
	}
	
	
	
	@RequestMapping(value="/deleteCat/{id}",method=RequestMethod.GET)
	public ModelAndView deleteCategoryInfo(@PathVariable(value="id") String id) {
		
		Category cat = new Category();
		cat.setId(Integer.parseInt(id));
		
		catService.deleteCategory(cat);
		
		ModelAndView mp =new ModelAndView("catSuccess");
		mp.addObject("msg", "Category deleted successfully!!!!!");
		
		return mp;
	}
	
	
	
	@RequestMapping(value="/updateCat/{id}",method=RequestMethod.GET)
	public ModelAndView editCategoryInfo(@PathVariable(value="id") String id) {
		
		Category cat =  catService.getCategoryInfo(Integer.parseInt(id));
		
		ModelAndView mp =new ModelAndView("catEdit");
		mp.addObject("cat", cat);
		
		return mp;
	}
	
	@RequestMapping(value="/updateCat",method=RequestMethod.POST)
	public ModelAndView updateCategoryInfo(@RequestParam("id") String id,@RequestParam("cat_name") String name,@RequestParam("org_id") String org_id) {
		
		Category category = catService.getCategoryInfo(Integer.parseInt(id));
		category.setName(name);
		category.setOrg_id(org_id);
		
		Category cat = catService.createCategory(category);
		ModelAndView mp =new ModelAndView("catSuccess");
		
		mp.addObject("cat",cat);
		mp.addObject("msg", "Category Updated successfully!!!!!");
		
		
		return mp;
	}
	
	
	
}
