package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	// dependency
	@Autowired
	private IVendorService service;

	public AdminController() {
		System.out.println("in constr of " + getClass().getName());
	}

	@GetMapping("/list")
	public String showVendorList(Model map) {
		System.out.println("in list vendor");
		// save vendor under model map
		map.addAttribute("vendor_list", service.listVendors());
		return "/admin/list"; //forward view name
	}
	@GetMapping("/delete")
	public String deleteVendor(@RequestParam int vid,
			RedirectAttributes flashMap) {
		System.out.println("in delete vendor "+vid+" "+flashMap);
		flashMap.addFlashAttribute("status",service.deleteVendor(vid));
			return "redirect:/admin/list"; //redirect view name
	}
	@GetMapping("/add")
	public String showRegForm(Vendor v) {
		// Vendor v=new Vendor();
		//invokes all getters to  bind POJO data to form
		//map.addAttribute("vendor",v); //derived name
		System.out.println("in show reg form "+v);
			return "/admin/register"; //forward to reg form
	}
	@PostMapping("/add")
	public String processRegForm(Vendor v,RedirectAttributes flashMap)
	{
		//Vendor v=new Vendor();
		//invokes matching setters (req param names--path
//--MUST match POJO prop names.
		System.out.println("in process reg form "+v);
		//v -- transient
		flashMap.addFlashAttribute("status", service.registerVendor(v));
		return "redirect:/admin/list";
	}
	//req handling method for showing updation form
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam int vid,Model map)
	{
		System.out.println("in show update form ");
		//load vendor details from db & attach it to model attribute
		map.addAttribute("vendor",service.getVendorDetails(vid));
		System.out.println(map);
		return "/admin/update";
	}
	@PostMapping("/update")
	public String processUpdateForm(Vendor v,RedirectAttributes flashMap)
	{
		System.out.println("in process update "+v);
		//invoke service --dao --to update vendor dtls
		flashMap.addFlashAttribute("status", service.updateVendor(v));
		return "redirect:/admin/list";
	}
	

}
