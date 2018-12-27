package com.pt.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping("/home")
	public ModelAndView showhome() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
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
