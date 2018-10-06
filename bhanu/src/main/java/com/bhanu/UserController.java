package com.bhanu;

import java.security.Principal;
import java.time.LocalDate;
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
import com.bhanu.dao.Contactdao;
import com.bhanu.dao.Customerdao;
import com.bhanu.dao.Feedbackdao;
import com.bhanu.dao.Offerdao;
import com.bhanu.dao.Orderdao;
import com.bhanu.dao.Productdao;
import com.bhanu.model.Cart;
import com.bhanu.model.Contact;
import com.bhanu.model.Customer;
import com.bhanu.model.Product;
import com.bhanu.model.Feedback;
import com.bhanu.model.OrderItem;
import com.bhanu.model.Order;
import com.bhanu.model.Offer;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	Productdao productdao;
	
	@Autowired
	Cartdao cartdao;
	
	@Autowired
	Offerdao offerdao;
	
	@Autowired
	Orderdao orderdao;
	
	@Autowired
	Customerdao customerdao;
	
	@Autowired
	Feedbackdao feedbackdao;
	
	@Autowired 
	Contactdao contactdao;
	
	@RequestMapping(value="/allproducts")
	public ModelAndView Allproduct()
	{
		ModelAndView  mv= new ModelAndView();
		List<Product> list = productdao.GetAllProduct();
		mv.addObject("list",list);
		mv.setViewName("AllProductUser");
		return mv;
	}	
	
	@RequestMapping("/product/{product_id}")
	public String Product(@PathVariable("product_id") int product_id,Model model)
	{
		Product product=productdao.GetProduct(product_id);
		model.addAttribute("product",product);
		return "product";
	}
	
	@RequestMapping(value="/addtocart/{product_id}",method=RequestMethod.GET)
	public String addToCart(@PathVariable(value="product_id") int product_id,HttpServletRequest request,Model model)
	{
		Principal principal=request.getUserPrincipal();
		String Username=principal.getName();
		if(cartdao.isIncart(product_id, Username))
			return "redirect:/user/cart";
		Cart cart=new Cart();
		cart.setProduct_id(product_id);
		cart.setCustomer(Username);
		cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		cartdao.addToCart(cart);
		return "redirect:/user/cart";
	}
	
	@RequestMapping("/cart")
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
		model.addAttribute("details",customerdao.getCustomer(Username).getDetails());
		model.addAttribute("pincode",customerdao.getCustomer(Username).getPincode());
		return "Cart";
	}
	
	@RequestMapping("/removefromcart/{product_id}")
	public String removeFromCart(@PathVariable(value="product_id") int product_id,HttpServletRequest request,Model model)
	{
		Principal principal=request.getUserPrincipal();
		String Username=principal.getName();
		cartdao.removeFromCart(product_id, Username);
		return "redirect:/user/cart";
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
	
	@RequestMapping("/applyoffer")
	public String applyOffer(Model model,HttpServletRequest request)
	{
		int offer_id=Integer.parseInt(request.getParameter("offer_id"));
		if(offer_id==0)
			offer_id=1;
		model.addAttribute("offer_id",offer_id);
		String Username=request.getUserPrincipal().getName();
		model.addAttribute("details",customerdao.getCustomer(Username).getDetails());
		model.addAttribute("pincode",customerdao.getCustomer(Username).getPincode());
		
		return viewOfferCart(model,request,offer_id); 
	}
	
	@RequestMapping("/order/{net_price}")
	public String placeOfferOrder(Model model,HttpServletRequest request,@PathVariable(value="net_price") int net_price)
	{
		String Username=request.getUserPrincipal().getName();
		String date=LocalDate.now().toString();
		String details=request.getParameter("details");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		int orderId=orderdao.placeOrder(Username,cartdao.getPrice(Username),net_price,Integer.parseInt(request.getParameter("offer_id")),details,pincode,date);
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
		return "redirect:/user/orderitems/"+orderId;
	}
	
	@RequestMapping("/allorders")
	public String orders(Model model,HttpServletRequest request)
	{
		String Username=request.getUserPrincipal().getName();
		List<Order> list=orderdao.getOrders(Username);
		model.addAttribute("list",list);
		return "orders";
	}
	@RequestMapping("/orderitems/{orderId}")
	public String getOrderItems(Model model,@PathVariable(value="orderId") int orderId,HttpServletRequest request)
	{
		List<OrderItem> list=orderdao.getOrderItems(orderId);
		model.addAttribute("list",list);
		model.addAttribute("order",orderdao.getOrder(orderId));
		return "order";
	}
	@RequestMapping("/profile")
	public String Profile(HttpServletRequest request,Model model)
	{
		String Username=request.getUserPrincipal().getName();
		Customer customer =customerdao.getCustomer(Username);
		List<Contact> contacts= contactdao.Allcontact(Username);
		model.addAttribute("Customer",customer);
		model.addAttribute("contacts", contacts);
		return "profile";
	}
	
	@RequestMapping(value="/edit_profile", method=RequestMethod.GET)
	public String editProfile(Model model,HttpServletRequest request)
	{
		Customer customer=customerdao.getCustomer(request.getUserPrincipal().getName());
		model.addAttribute("customer",customer);
		return "Editprofile";
	}
	
	@RequestMapping(value="/edit_profile", method=RequestMethod.POST)
	public String editProfile(HttpServletRequest request)
	{
		Customer customer=new Customer();
		customer.setDetails(request.getParameter("details"));
		customer.setName(request.getParameter("name"));
		customer.setContact(request.getParameter("contact"));
		customer.setPincode(Integer.parseInt(request.getParameter("pincode")));
		customerdao.editProfile(customer,request.getUserPrincipal().getName());
		return "redirect:profile";
	}
	
	@RequestMapping(value="/addfeedback/{product_id}",method=RequestMethod.GET)
	public String addFeedback(Model model,@PathVariable(value="product_id") int product_id,HttpServletRequest request)
	{
		Principal principal=request.getUserPrincipal();
		Feedback feedback=new Feedback();
		feedback.setProduct(product_id);
		feedback.setCustomer(principal.getName());
		model.addAttribute("feedback",feedback);
		return "Addfeedback";
	}
	
	@RequestMapping(value="/addfeedback/{product_id}",method=RequestMethod.POST)
	public String addfeedback(@Valid @ModelAttribute("Feedback") Feedback feedback,BindingResult result,Model model,@PathVariable(value="product_id") int product_id)
	{
		if(result.hasErrors())
		{
			model.addAttribute("error","yes");
			return "redirect:/feedback/"+product_id;
		}
		else
		{
			feedbackdao.addFeedback(feedback);
			return "redirect:/user";
		}
	}
	
	@RequestMapping("/feedbacks/{product_id}")
	public String getAllFeedback(@PathVariable(value="product_id") int product_id,Model model)
	{
		List<Feedback> list=(List<Feedback>) feedbackdao.getFeedbacks(product_id);
		model.addAttribute("list",list);
		return "Feedbacks";
	}
	
	@RequestMapping(value="/addcontact",method=RequestMethod.GET)
	public String Addcontact(HttpServletRequest request,Model model)
	{
		String username=request.getUserPrincipal().getName();
		Contact contact=new Contact();
		model.addAttribute("contact",contact);
		return "Addcontact";
	}
	
	@RequestMapping(value="/addcontact",method=RequestMethod.POST)
	public String Addcontactform(HttpServletRequest request)
	{
		String username=request.getUserPrincipal().getName();
		Contact contact=new Contact();
		contact.setCustomer(username);
		contact.setContact(request.getParameter("Contact"));
		contactdao.Addcontact(contact);
		return "redirect:profile";
	}
	
	
	@RequestMapping("/deletecontact/{contact_id}")
	public String Deletecontact(@PathVariable("contact_id") int contact_id)
	{
		contactdao.deletecontact(contact_id);
		return "redirect:../profile";
	}
}
