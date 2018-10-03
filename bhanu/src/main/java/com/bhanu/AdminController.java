package com.bhanu;

import java.sql.ResultSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bhanu.dao.Customerdao;
import com.bhanu.dao.Employeedao;
import com.bhanu.dao.Offerdao;
import com.bhanu.dao.Productdao;
import com.bhanu.model.Customer;
import com.bhanu.model.Employee;
import com.bhanu.model.Offer;
import com.bhanu.model.Product;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public Productdao productdao;
	
	@Autowired
	public Employeedao employeedao;
	
	@Autowired
	public Offerdao offerdao;
	
	@Autowired
	public Customerdao customerdao;
	
	@RequestMapping(value="/addproduct",method=RequestMethod.GET)
	public String Addproduct(Model model)
	{
		Product product = new Product();
		model.addAttribute("product",product);
		return "AddProduct";
	}
	
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public String AddproductTbl(@Valid @ModelAttribute("product") Product product,BindingResult result,Model model )
	{
		if(result.hasErrors())
		{
			return "AddProduct";
		}
		int MRP=product.getMRP();
		int discount=product.getDiscount();
		int price=MRP-(discount*MRP)/100;
		product.setPrice(price);
		productdao.SaveOrUpdate(product);
		
		return "redirect:/admin";
	}
	@RequestMapping(value="/addemployee",method=RequestMethod.GET)
	public String Addemployee(Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "AddEmployee";
	}
	
	@RequestMapping(value="/addemployee",method=RequestMethod.POST)
	public String AddemployeeTbl(@Valid @ModelAttribute("employee") Employee employee,BindingResult result,Model model )
	{
		if(result.hasErrors())
		{
			return "AddEmployee";
		}
	    employeedao.Save(employee);
		
		return "redirect:/admin";
	}
	@RequestMapping(value="/addoffer",method=RequestMethod.GET)
	public String AddOffer(Model model)
	{
		Offer offer = new Offer();
		model.addAttribute("offer",offer);
		return "AddOffer";
	}
	
	@RequestMapping(value="/addoffer",method=RequestMethod.POST)
	public String AddofferTbl(@Valid @ModelAttribute("offer") Offer offer,BindingResult result,Model model )
	{
		if(result.hasErrors())
		{
			return "AddOffer";
		}
	    offerdao.SaveOrUpdate(offer);
		
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/allproduct",method=RequestMethod.GET)
	public ModelAndView Allproduct()
	{
		ModelAndView  mv= new ModelAndView();
		List<Product> list = productdao.GetAllProduct();
		mv.addObject("list",list);
		mv.setViewName("AllProduct");
		return mv;
	}
	
	@RequestMapping(value="/updateproduct/{product_id}",method=RequestMethod.GET)
	public ModelAndView UpdateProduct(@PathVariable(value="product_id") int product_id)
	{
		ModelAndView mv= new ModelAndView();
		Product product=new Product();
		product= productdao.GetProduct(product_id);
		mv.addObject("product",product);
		mv.setViewName("UpdateProduct");
		return mv;
	}
	
	@RequestMapping(value="/updateproduct/{product_id}",method=RequestMethod.POST)
	public String UpdateProductTbl(@Valid @ModelAttribute("product") Product product,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "UpdateProduct";
		}
		int MRP=product.getMRP();
		int discount=product.getDiscount();
		int price=MRP-(discount*MRP)/100;
		product.setPrice(price);
		productdao.Update(product);
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/alloffer",method=RequestMethod.GET)
	public ModelAndView Alloffer()
	{
		ModelAndView  mv= new ModelAndView();
		List<Offer> list = offerdao.GetAllOffer();
		mv.addObject("list",list);
		mv.setViewName("AllOffer");
		return mv;
	}
	
	@RequestMapping(value="/updateoffer/{offer_id}",method=RequestMethod.GET)
	public ModelAndView UpdateOffer(@PathVariable(value="offer_id") int offer_id)
	{
		ModelAndView mv= new ModelAndView();
		Offer offer=new Offer();
		offer= offerdao.GetOffer(offer_id);
		mv.addObject("offer",offer);
		mv.setViewName("UpdateOffer");
		return mv;
	}
	
	@RequestMapping(value="/updateoffer/{offer_id}",method=RequestMethod.POST)
	public String UpdateOfferTbl(@Valid @ModelAttribute("offer") Offer offer,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "redirect:/admin";
		}
		offerdao.UpdateOffer(offer);
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/addcustomer",method=RequestMethod.GET)
	public String register(Model model) {
		
		Customer customer = new Customer();
		//User user = new User();
		model.addAttribute("customer", customer);

		return "AddCustomer";
	}
	
	@RequestMapping(value="/addcustomer",method=RequestMethod.POST)
	public String registerProcess(@Valid @ModelAttribute("customer") Customer customer,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "AddCustomer";
		}
		else {
			if(!customer.getPassword().equals(customer.getmPassword())) {
				model.addAttribute("error","passwords dont match");
				return "AddCustomer";
			}
			if(customerdao.getUser(customer.getUsername())!=null&&customerdao.getCustomer(customer.getUsername())!=null) {
				model.addAttribute("error", "username exists");
				return "AddCustomer";
			}
			customerdao.SaveOrUpdateUSERS(customer);
			customerdao.SaveOrUpdateCustomer(customer);
			return "redirect:/admin";
		}
	}
	
}
