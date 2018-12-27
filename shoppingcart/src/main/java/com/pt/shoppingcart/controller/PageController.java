package com.pt.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping("/home")
	public ModelAndView showpage() {
		ModelAndView mv=new ModelAndView("page");
		return mv;
	}
}
