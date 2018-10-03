package com.bhanu;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bhanu.dao.Cartdao;
import com.bhanu.dao.Productdao;
import com.bhanu.model.Cart;
import com.bhanu.model.Product;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	Productdao productdao;
	
	@Autowired
	Cartdao cartdao;
	
	@RequestMapping(value="/allproducts")
	public ModelAndView Allproduct()
	{
		ModelAndView  mv= new ModelAndView();
		List<Product> list = productdao.GetAllProduct();
		mv.addObject("list",list);
		mv.setViewName("AllProductUser");
		return mv;
	}	
	
	@RequestMapping(value="/addtocart/{product_id}",method=RequestMethod.GET)
	public String AddToCart(@PathVariable(value="product id") int product_id,Principal principle)
	{
		Cart cart= new Cart();
		String Username=principle.getName();
		cart.setCustomer(Username);
		cart.setProduct_id(product_id);
		cartdao.SaveOrUpdate(cart);
		return "redirect:/user";
	}
}
