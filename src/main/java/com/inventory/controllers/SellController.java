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
import com.inventory.dao.SellDao;
import com.inventory.services.CategoryService;
import com.inventory.services.ItemService;
import com.inventory.services.SellService;
import com.inventory.models.Category;
import com.inventory.models.Item;
import com.inventory.models.Sell;

@Controller
public class SellController {

	@Autowired
	ItemService itemService;
	@Autowired
	SellService sellService;
	
	
	
	@Autowired
	private  ItemDao itemDao;
	
	@Autowired
	private SellDao sellDao;
	
	@RequestMapping(value="/getSells",method=RequestMethod.GET)
	@ResponseBody
	public String getSells(){
		Gson json = new Gson();
		return json.toJson(sellDao.findAll());
	}
	
	 
	@RequestMapping(value="/manageSell",method=RequestMethod.GET)
	public ModelAndView getManageSell() {
		
		ModelAndView mp =new ModelAndView("manageSell");
		
		List<Sell> sellList =  sellDao.findAll();
		System.out.print(sellList);
		mp.addObject("sellList", sellList);
		return mp;
	}
	
	
	@RequestMapping(value="/addSell",method=RequestMethod.GET)
	public ModelAndView addCategory() {
		
        ModelAndView mp =new ModelAndView("addSell");
        Iterable<Item> itemList = itemService.findAllItems();
		mp.addObject("itemList",itemList);
		
		return mp;
	}
	
	@RequestMapping(value="/addSell",method=RequestMethod.POST)
	public ModelAndView addCategoryInfo(@RequestParam("inv_no") String inv_no,@RequestParam("name") String name,@RequestParam("item_id") String item_id,@RequestParam("quantity") String quantity) {
		
		Sell sell = new Sell();
		
		//calculation for sub_total
		int id = Integer.parseInt(item_id);
		Item item = itemService.getItemInfo(id);
		double price = Integer.parseInt(item.getPrice());
		double sub_total = Integer.parseInt(quantity)*price;
		
		sell.setInv_no(inv_no);
		sell.setName(name);
		sell.setItem_id(item_id);
		sell.setQuantity(quantity);
		sell.setSub_total(sub_total);
		sell.setCreation_date(new Date());
		
		Sell sellnew = sellService.createSell(sell);
		ModelAndView mp =new ModelAndView("catSuccess");
		
		mp.addObject("sell",sellnew);
		mp.addObject("msg", "Sell added successfully!!!!!");
		
	
		return mp;
	}
	

	
	@RequestMapping(value="/searchSell",method=RequestMethod.POST)
	public ModelAndView searchInvoiceInfo(@RequestParam("inv_no") String inv_no) {
		
		List<Sell> sellList = sellService.getSellByInvoice(inv_no);
		
		ModelAndView mp =new ModelAndView("manageSell");
		mp.addObject("sellList",sellList);
		
		
		return mp;
	}
	

	
	
	@RequestMapping(value="/deleteSell/{id}",method=RequestMethod.GET)
	public ModelAndView deleteSellInfo(@PathVariable(value="id") String id) {
		
		Sell sell = new Sell();
		sell.setId(Integer.parseInt(id));
		
		sellService.deleteSell(sell);
		
		ModelAndView mp =new ModelAndView("catSuccess");
		mp.addObject("msg", "Sell deleted successfully!!!!!");
		
		return mp;
	}
	
	
	
	@RequestMapping(value="/updateSell/{id}",method=RequestMethod.GET)
	public ModelAndView editSellInfo(@PathVariable(value="id") String id) {
		
		Sell sell =  sellService.getSellInfo(Integer.parseInt(id));
		ModelAndView mp =new ModelAndView("sellEdit");
		 
		Iterable<Item> itemList = itemService.findAllItems();
		mp.addObject("itemList",itemList);
		
		mp.addObject("sell", sell);
		
		return mp;
	}
	
	@RequestMapping(value="/updateSell",method=RequestMethod.POST)
	public ModelAndView updateSellInfo(@RequestParam("id") String id,@RequestParam("inv_no") String inv_no,@RequestParam("name") String name,@RequestParam("item_id") String item_id,@RequestParam("quantity") String quantity) {
		
		Sell sell = sellService.getSellInfo(Integer.parseInt(id));
		
		//calculation for sub_total
		int temp_id = Integer.parseInt(item_id);
		Item item = itemService.getItemInfo(temp_id);
		double price = Integer.parseInt(item.getPrice());
		double sub_total = Integer.parseInt(quantity)*price;
		
		sell.setInv_no(inv_no);
		sell.setName(name);
		sell.setItem_id(item_id);
		sell.setQuantity(quantity);
		sell.setSub_total(sub_total);
		
		Sell sellnew = sellService.createSell(sell);
		ModelAndView mp =new ModelAndView("catSuccess");
		
		mp.addObject("sell",sellnew);
		mp.addObject("msg", "Sell updated successfully!!!!!");
		
		
		return mp;
	}
	
	
	
}
