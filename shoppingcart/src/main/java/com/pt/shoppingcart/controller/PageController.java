package com.pt.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.prathap.shoppingbackend.dao.CatagoryDAO;
import net.prathap.shoppingbackend.dto.Catagory;

@Controller
public class PageController {
	
	@Autowired
	private CatagoryDAO dao;
	
	@RequestMapping("/home")
	public ModelAndView showhome() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
		List<Catagory> listcat=dao.Sendcatagaries();
		listcat.forEach(cat->{
			System.out.println(cat.getCatagoryname()+"=="+cat.getDescription());
		});
		mv.addObject("catagories", dao.Sendcatagaries());
		mv.addObject("userclickHome", true);
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView showabout() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userclickAbout", true);
		return mv;
	}
	@RequestMapping("/contact")
	public ModelAndView showpage() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userclickContact", true);
		return mv;
	}
}
