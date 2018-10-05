package com.bhanu;

import java.security.Principal;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.bhanu.dao.Cartdao;
import com.bhanu.dao.Customerdao;
import com.bhanu.dao.Employeedao;
import com.bhanu.dao.Feedbackdao;
import com.bhanu.dao.Mayreturndao;
import com.bhanu.dao.Offerdao;
import com.bhanu.dao.Orderdao;
import com.bhanu.dao.Productdao;
import com.bhanu.dao.Productfittingdao;
import com.bhanu.dao.Salaryrecorddao;
import com.bhanu.model.Cart;
import com.bhanu.model.Customer;
import com.bhanu.model.Employee;
import com.bhanu.model.Feedback;
import com.bhanu.model.Mayreturn;
import com.bhanu.model.Offer;
import com.bhanu.model.Product;
import com.bhanu.model.Productfitting;
import com.bhanu.model.Salaryrecord;
import com.bhanu.model.OrderItem;
import com.bhanu.model.Order;

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
	
	@Autowired 
	Orderdao orderdao;
	
	@Autowired
	Cartdao cartdao;
	
	@Autowired
	Feedbackdao feedbackdao;
	
	@Autowired
	Mayreturndao mayreturndao;
	
	@Autowired
	Productfittingdao productfittingdao;
	
	@Autowired
	Salaryrecorddao salaryrecorddao;
	
	
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
	
	@RequestMapping("/orders")
	public String getAllOrders(Model model)
	{
		List<Order> list=orderdao.getAllOrders();
		model.addAttribute("list",list);
		return "orders";
	}
	
	@RequestMapping("/orderitems/{orderId}")
	public String getOrderItems(@PathVariable(value="orderId") int orderId,Model model)
	{
		List<OrderItem> list=orderdao.getOrderItems(orderId);
		Order order= new Order();
		order=orderdao.getOrder(orderId);
		model.addAttribute("order", order);
		model.addAttribute("list",list);
		return "mayreturn";
	}
	
	@RequestMapping(value="/assignemployee/{orderId}",method=RequestMethod.GET)
	public String assignEmployeE(Model model,HttpServletRequest request,@PathVariable(value="orderId") int orderId)
	{
		List<OrderItem> list=orderdao.getOrderItems(orderId);
		model.addAttribute("list",list);
		List<Employee> employees=employeedao.getAllEmployee();
		model.addAttribute("employees",employees);
		return "Adminorder";
	}
	
	@RequestMapping(value="/assignemployee/{orderId}",method=RequestMethod.POST)
	public String assignEmployee(Model model,HttpServletRequest request,@PathVariable(value="orderId") int orderId)
	{
		int empId=Integer.parseInt(request.getParameter("empId"));
		orderdao.assignEmployee(orderId, empId);
		return "redirect:/admin/unassignedorders";
	}
	
	@RequestMapping("/unassignedorders")
	public String getAllunassignedOrders(Model model)
	{
		List<Order> list=orderdao.getAllunassignedOrders();
		model.addAttribute("list",list);
		return "Unassignedorder";
	}
	
	@RequestMapping("/employees")
	public String allEmployees(Model model)
	{
		List<Employee> list=employeedao.getAllEmployee();
		model.addAttribute("list",list);
		return "Employees";
	}
	
	@RequestMapping("/addorder")
	public String Addorder()
	{
		return "Addorderadmin";
	}
	
	@RequestMapping(value="Allproducts")
	public ModelAndView Allproductadd()
	{
		ModelAndView  mv= new ModelAndView();
		List<Product> list = productdao.GetAllProduct();
		mv.addObject("list",list);
		mv.setViewName("Allproductadmin");
		return mv;
	}
	
	@RequestMapping(value="addtocart/{product_id}",method=RequestMethod.GET)
	public String addToCart(@PathVariable(value="product_id") int product_id,HttpServletRequest request,Model model)
	{
		Principal principal=request.getUserPrincipal();
		String Username=principal.getName();
		if(cartdao.isIncart(product_id, Username))
			return "redirect:/admin/cart";
		Cart cart=new Cart();
		cart.setProduct_id(product_id);
		cart.setCustomer(Username);
		//int i=Integer.parseInt(request.getParameter("quantity"));
		//productdao.UpdateQuantity(product_id,i);
//		System.out.println(Integer.parseInt(request.getParameter("quantity")));
		cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		cartdao.addToCart(cart);
		return "redirect:/admin/Allproducts";
	}
	
	@RequestMapping("cart")
	public String viewCart(Model model,HttpServletRequest request)
	{
		Principal principal=request.getUserPrincipal();
		String Username=principal.getName();
		List<Cart> list=cartdao.getCartItems(Username);
		model.addAttribute("list",list);
		model.addAttribute("price",cartdao.getPrice(Username));
		model.addAttribute("net_price",cartdao.getPrice(Username));
		List<Offer> offers=offerdao.getOffers();
		model.addAttribute("offers",offers);
		model.addAttribute("offer_id", 1);
		return "Cart";
	}
	
	
	public String viewOfferCart(Model model,HttpServletRequest request,int offer_id)
	{
		Principal principal=request.getUserPrincipal();
		String userId=principal.getName();
		List<Cart> list=cartdao.getCartItems(userId);
		model.addAttribute("list",list);
		int price=cartdao.getPrice(userId);
		model.addAttribute("price",price);
		model.addAttribute("net_price",price-offerdao.GetOffer(offer_id).getDiscount()*price/100);
		List<Offer> offers=offerdao.getOffers();
		model.addAttribute("offers",offers);
		model.addAttribute("offer_id", offer_id);
		return "Cart";
	}
	
	@RequestMapping("applyoffer")
	public String applyOffer(Model model,HttpServletRequest request)
	{
		int offer_id=Integer.parseInt(request.getParameter("offer_id"));
		if(offer_id==0)
			offer_id=1;
		model.addAttribute("offer_id",offer_id);
		return viewOfferCart(model,request,offer_id); 
	}
	
	
	@RequestMapping("order/{net_price}")
	public String placeOfferOrder(Model model,HttpServletRequest request,@PathVariable(value="net_price") int net_price)
	{
		String Username=request.getUserPrincipal().getName();
		int orderId=orderdao.placeOrder(Username,cartdao.getPrice(Username),net_price,Integer.parseInt(request.getParameter("offer_id")));
		List<Cart> list=cartdao.getCartItems(Username);
		Iterator<Cart> itr=list.iterator();
		while(itr.hasNext())
		{
			Cart cart=itr.next();
			orderdao.addToOrder(orderId, cart.getProduct_id(),cart.getQuantity());
			int count=productdao.GetProduct(cart.getProduct_id()).getQuantity();
			count=cart.getQuantity();
			if(count>=0)
				productdao.UpdateQuantity(cart.getProduct_id(), count);
			cartdao.removeFromCart(cart.getProduct_id(), Username);
		}
		return "redirect:/admin/orderitem/"+orderId;
	}
	
	
	@RequestMapping("/feedbacks/{product_id}")
	public String getAllFeedback(@PathVariable(value="product_id") int product_id,Model model)
	{
		List<Feedback> list=feedbackdao.getFeedbacks(product_id);
		model.addAttribute("list",list);
		return "Feedbacks";
	}
	
	@RequestMapping("/orderitem/{orderId}")
	public String getOrderItem(@PathVariable(value="orderId") int orderId,Model model)
	{
		List<OrderItem> list=orderdao.getOrderItems(orderId);
		Order order= new Order();
		order=orderdao.getOrder(orderId);
		model.addAttribute("order", order);
		model.addAttribute("list",list);
		return "mayreturn";
	}
	
	@RequestMapping("/returnitem")
	public String Addreturn(HttpServletRequest request)
	{
		Mayreturn mayreturn = new Mayreturn();
		int product_id=Integer.parseInt(request.getParameter("product_id"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int order_id=Integer.parseInt(request.getParameter("order_id"));
		String customer=request.getParameter("customer");
		String deadline=request.getParameter("deadline");
		int price=productdao.GetProduct(product_id).getPrice()*quantity;
		mayreturn.setCustomer(customer);
		mayreturn.setQuantity(quantity);
		mayreturn.setDeadline(deadline);
		mayreturn.setPrice(price);
		mayreturn.setProduct_id(product_id);
		mayreturndao.insert(mayreturn);
		return "redirect:/admin/orderitem/"+order_id;
	}
	
	@RequestMapping("/productfitting")
	public String Productfiting(HttpServletRequest request)
	{
		Productfitting productfitting= new Productfitting();
		int product_id=Integer.parseInt(request.getParameter("product_id"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int order_id=Integer.parseInt(request.getParameter("order_id"));
		String customer=request.getParameter("customer");
		String deadline=request.getParameter("deadline");
		String details=request.getParameter("details");
		productfitting.setCustomer(customer);
		productfitting.setQuantity(quantity);
		productfitting.setDeadline(deadline);
		productfitting.setProduct_id(product_id);
		productfitting.setDetails(details);
		int status=0;
		productfitting.setStatus(status);
		productfittingdao.Insert(productfitting);
		return "redirect:/admin/orderitem/"+order_id;
	}
	
	@RequestMapping("/searchCustomer")
	public String SearchCustomer(Model model,HttpServletRequest request)
	{
		String Phoneno=request.getParameter("phoneno.");
		List<Customer> list;
		list=customerdao.Search(Phoneno);
		model.addAttribute("list",list);
		return "Customersearch";
	}
	
	
	@RequestMapping(value="/paysalary/{employee_id}",method=RequestMethod.GET)
	public String Paysalry(Model model,@PathVariable(value="employee_id") int employee_id)
	{
		Calendar cal=Calendar.getInstance();
		Salaryrecord record=new Salaryrecord();
		record.setEmployee_id(employee_id);
		if(salaryrecorddao.isPaid(employee_id, cal.get(cal.MONTH), cal.get(cal.YEAR)))
		{
			model.addAttribute("error","Already paid for this month");
		}
		model.addAttribute("month",cal.get(cal.MONTH));
		model.addAttribute("year",cal.get(cal.YEAR));
		model.addAttribute("salary",employeedao.getEmployee(employee_id).getSalary());
		model.addAttribute("record",record);
		return "Salarypay";
	}
	
	
	@RequestMapping(value="/paysalary/{employee_id}",method=RequestMethod.POST)
	public String addRecord(Model model,@Valid @ModelAttribute("record") Salaryrecord record,BindingResult result)
	{
		if(result.hasErrors())
		{
			model.addAttribute("error","Incorrect Information filled");
			model.addAttribute("record",record);
			return "salaryForm";
		}
		else
		{
			salaryrecorddao.addRecord(record);
			return "redirect:/admin/employeesalaryrecords/"+record.getEmployee_id();
		}
	}
	
	
	@RequestMapping("/employeesalaryrecords/{employee_id}")
	public String getRecords(Model model,@PathVariable(value="employee_id") int employee_id)
	{
		model.addAttribute("list",salaryrecorddao.getRecords(employee_id));
		model.addAttribute("employee_id",employee_id);
		return "Employeesalaryrecord";
	}
	
	
	@RequestMapping("/allsalaryrecords")
	public String getAllRecords(Model model)
	{
		model.addAttribute("list",salaryrecorddao.getAllRecords());
		return "Salaryrecords";
	}
	
	
	@RequestMapping("/orderemployee/{employee_id}")
	public String getAssignedOrders(@PathVariable(value="employee_id") int employee_id,Model model)
	{
		model.addAttribute("list",orderdao.getAssignedOrders(employee_id));
		model.addAttribute("employee",employeedao.getEmployee(employee_id));
		return "Assignedorder"; 
	}
}
