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
public class HomeController {


	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index() {
		
		return "login";
	}
	
	@RequestMapping(value="/error",method=RequestMethod.GET)
	public String error() {
		
		return "error";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginPage() {
		
		return "login";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String getLogOutPage() {
		
		return "login";
	}
	
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String getAdminPage() {
		
		return "adminHome";
	}
	
	@Autowired
	private  CategoryDao catDao;
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView getLoginInfo(@RequestParam("username") String uname,@RequestParam("password") String password,@RequestParam("type") String type) {
		ModelAndView mp;
		
		if(type.equalsIgnoreCase("Admin")) {
		
		if(uname.equalsIgnoreCase("bappy") && password.equalsIgnoreCase("1234")) {
		mp =new ModelAndView("adminHome");
		mp.addObject("user", uname);
		return mp;
		}
		else {
	    mp =new ModelAndView("error");
	    mp.addObject("msg", "Incorrect Credentials!!!!");
	    return mp;
		}
	 }else {
		 mp =new ModelAndView("error");
		 return mp;
	 }
		
	}
	
	
	
	
	
}
