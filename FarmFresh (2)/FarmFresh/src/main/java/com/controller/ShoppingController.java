package com.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.exception.NoStockException;
import com.model.Product;
import com.service.ShoppingService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//use appropriate annotation to configure ShoppingController as Controller
public class ShoppingController {
	
	//use appropriate annotation
	@Autowired
	private ShoppingService shoppingService;
	
	@GetMapping("/showPage")
	public String showPage(@ModelAttribute("product")Product product) {
		
		System.out.println("I am in Controller");
		
		return "showPage";
		
	}

	//invoke the service class - calculateCost method.
   @PostMapping("/bill")
	public String calculateCost(@Valid @ModelAttribute("product")  Product product, BindingResult result,ModelMap model) throws NoStockException {
		
		//fill the code 
    	if (result.hasErrors()) {
			 System.out.println("Error : " + result.toString());
			 return "showPage";
			}
    	System.out.println("I am calculating cost");
		double cost=shoppingService.calculateCost(product);
		model.addAttribute("cost",cost);
		 		
		return "billDesk";
	}
    
    @ModelAttribute("productNames")
    public List<String> populateProduct(){
    	
    	List<String> list=new ArrayList<String>();
    	list.add("Apple");
    	list.add("Orange");
    	list.add("Grapes");
    	list.add("Mango");
    	list.add("JackFruit");
    	
    	return list;
    	
    }
	

	//use appropriate annotation 
    @ExceptionHandler(NoStockException.class)
	public ModelAndView exceptionHandler(Exception exception) {
    	
//    	String msg = exception.getMessage();
//    	return new ModelAndView("exceptionPage");
    	ModelAndView modelAndView = new ModelAndView();
    	  modelAndView.setViewName("exceptionPage");
    	  modelAndView.addObject("msg", exception.getMessage());
    	  return modelAndView;
		
		
		//fill the code
 		   
	}
	
}
