package com.inventory.controllers;

import java.util.Date;
import java.util.Iterator;
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
import com.inventory.dao.ItemDao;
import com.inventory.services.CategoryService;
import com.inventory.services.ItemService;
import com.inventory.models.Category;
import com.inventory.models.Item;

@Controller
public class ItemController {

	@Autowired
	ItemService itemService;
	@Autowired
	CategoryService catService;
	
	
	
	@Autowired
	private  ItemDao itemDao;
	
	@RequestMapping(value="/getItems",method=RequestMethod.GET)
	@ResponseBody
	public String getItems(){
		Gson json = new Gson();
		return json.toJson(itemDao.findAll());
	}
	
	 
	@RequestMapping(value="/manageItem",method=RequestMethod.GET)
	public ModelAndView getManageItem() {
		
		ModelAndView mp =new ModelAndView("manageItem");
		
		List<Item> itemList =  itemDao.findAll();
		System.out.print(itemList);
		mp.addObject("itemList", itemList);
		return mp;
	}
	
	
	@RequestMapping(value="/addItem",method=RequestMethod.GET)
	public ModelAndView addCategory() {
		
        ModelAndView mp =new ModelAndView("addItem");
        Iterable<Category> catList = catService.findAllCat();
		mp.addObject("catList",catList);
		
		return mp;
	}
	
	@RequestMapping(value="/addItem",method=RequestMethod.POST)
	public ModelAndView addCategoryInfo(@RequestParam("name") String name,@RequestParam("cat_id") String cat_id,@RequestParam("quantity") String quantity,@RequestParam("price") String price) {
		
		Item item = new Item();
		item.setName(name);
		item.setCat_id(cat_id);
		item.setQuantity(quantity);
		item.setPrice(price);
		item.setCreation_date(new Date());
		
		Item itemnew = itemService.createItem(item);
		ModelAndView mp =new ModelAndView("catSuccess");
		
		mp.addObject("item",itemnew);
		mp.addObject("msg", "Item added successfully!!!!!");
		
	
		return mp;
	}
	

	
	@RequestMapping(value="/searchItem",method=RequestMethod.POST)
	public ModelAndView searchItemInfo(@RequestParam("name") String name) {
		
		List<Item> itemList = itemService.getItemByName(name);
		
		ModelAndView mp =new ModelAndView("manageItem");
		mp.addObject("itemList",itemList);
		
		
		return mp;
	}
	

	
	
	@RequestMapping(value="/deleteItem/{id}",method=RequestMethod.GET)
	public ModelAndView deleteItemInfo(@PathVariable(value="id") String id) {
		
		Item item = new Item();
		item.setId(Integer.parseInt(id));
		
		itemService.deleteItem(item);
		
		ModelAndView mp =new ModelAndView("catSuccess");
		mp.addObject("msg", "Item deleted successfully!!!!!");
		
		return mp;
	}
	
	
	
	@RequestMapping(value="/updateItem/{id}",method=RequestMethod.GET)
	public ModelAndView editItemInfo(@PathVariable(value="id") String id) {
		
		Item item =  itemService.getItemInfo(Integer.parseInt(id));
		ModelAndView mp =new ModelAndView("itemEdit");
		mp.addObject("item", item);
		
		return mp;
	}
	
	@RequestMapping(value="/updateItem",method=RequestMethod.POST)
	public ModelAndView updateItemInfo(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("cat_id") String cat_id,@RequestParam("quantity") String quantity,@RequestParam("price") String price) {
		
		Item item = itemService.getItemInfo(Integer.parseInt(id));
		item.setName(name);
		item.setCat_id(cat_id);
		item.setQuantity(quantity);
		item.setPrice(price);
		
		Item itemnew = itemService.createItem(item);
		ModelAndView mp =new ModelAndView("catSuccess");
		
		mp.addObject("item",itemnew);
		mp.addObject("msg", "Item updated successfully!!!!!");
		
		
		return mp;
	}
	
	
	
}
