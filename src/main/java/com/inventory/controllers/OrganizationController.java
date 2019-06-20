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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.inventory.dao.CategoryDao;
import com.inventory.models.Category;
import com.inventory.models.Organization;
import com.inventory.services.CategoryService;
import com.inventory.services.OrganizationService;

@Controller
public class OrganizationController {

	
	@Autowired
	OrganizationService orgService;
	
	
	
	
	 
	@RequestMapping(value="/manageOrganization",method=RequestMethod.GET)
	public ModelAndView getManageOrganization() {
		
		ModelAndView mp =new ModelAndView("manageOrganization");
		
		Iterable<Organization> orgList =  orgService.findAllOrganization();
		mp.addObject("orgList", orgList);
		return mp;
	}
	
	
	@RequestMapping(value="/addOrganization",method=RequestMethod.GET)
	public ModelAndView addCategory() {
		
        ModelAndView mp =new ModelAndView("addOrganization");
		
		return mp;
	}
	
	@RequestMapping(value="/addOrganization",method=RequestMethod.POST)
	public String addOrganizationInfo(@RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("address") String address,@RequestParam("uname") String uname,@RequestParam("password") String pass,RedirectAttributes attributes) {
		
		Organization org = new Organization();
		org.setName(name);
		org.setPhone(phone);
		org.setAddress(address);
		org.setUname(uname);
		org.setPass(pass);
		org.setCreation_date(new Date());
		
		Organization organization = orgService.createOrganization(org);
		
        attributes.addFlashAttribute("msg","Organization added successfully!!!!");
		
		return "redirect:/manageOrganization";
		
	}
	

	
	@RequestMapping(value="/searchOrganization",method=RequestMethod.POST)
	public String searchOrganizationInfo(@RequestParam("name") String name,RedirectAttributes attributes) {
		
		List<Organization> orgList = orgService.getOrganizationByName(name);
		
        attributes.addFlashAttribute("orgList",orgList);
		
		return "redirect:/manageOrganization";
	}
	
	
	
	
	@RequestMapping(value="/deleteOrganization/{id}",method=RequestMethod.GET)
	public String deleteOrganizationInfo(@PathVariable(value="id") String id,RedirectAttributes attributes) {
		
		Organization org = new Organization();
		org.setId(Integer.parseInt(id));
		
		orgService.deleteOrganization(org);
		attributes.addFlashAttribute("msg","Organization deleted successfully!!!!");
		
		return "redirect:/manageOrganization";
	}
	
	
	
	@RequestMapping(value="/updateOrganization/{id}",method=RequestMethod.GET)
	public ModelAndView editOrganizationInfo(@PathVariable(value="id") String id) {
		
		Organization org =  orgService.getOrganizationInfo(Integer.parseInt(id));
		
		ModelAndView mp =new ModelAndView("organizationEdit");
		mp.addObject("org", org);
		
		return mp;
	}
	
	@RequestMapping(value="/updateOrganization",method=RequestMethod.POST)
	public ModelAndView updateOrganizationInfo(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("address") String address,@RequestParam("uname") String uname,@RequestParam("password") String pass) {
		
		Organization organization = orgService.getOrganizationInfo(Integer.parseInt(id));
		organization.setName(name);
		organization.setPhone(phone);
		organization.setAddress(address);
		organization.setUname(uname);
		organization.setPass(pass);
		
		Organization org = orgService.createOrganization(organization);
		ModelAndView mp =new ModelAndView("catSuccess");
		
		mp.addObject("org",org);
		mp.addObject("msg", "Organization Updated successfully!!!!!");
		
		
		return mp;
	}
	
	
	
}
