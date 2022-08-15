package com.revature.ecommerce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.ecommerce.dto.EcomerceMessage;
import com.revature.ecommerce.entity.Address;
import com.revature.ecommerce.entity.Cart;
import com.revature.ecommerce.entity.ProductOrder;
import com.revature.ecommerce.exceptions.NoCartException;
import com.revature.ecommerce.exceptions.NoProductException;
import com.revature.ecommerce.service.CartService;
import com.revature.ecommerce.util.EcommerceConstants;

@RestController
@RequestMapping("cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	
	@Autowired
	CartService service;

	@CrossOrigin
	@PostMapping(path ="/addCart/{productid}/{userid}")
	public EcomerceMessage addToCart(@PathVariable("productid") int productId, @PathVariable("userid")String userId) {
		service.addCart(productId, userId);
		return new EcomerceMessage(EcommerceConstants.CART_ADDED);
	}

	@CrossOrigin
	@GetMapping(path = "viewCart/{userid}")
	public List<Cart> viewCart(@PathVariable("userid") String userID) throws NoCartException {
		return service.viewCart(userID);
	}

	@CrossOrigin
	@DeleteMapping(path ="delete/{cartid}")
	public EcomerceMessage deleteByCart(@PathVariable("cartid") int cartID) throws NoCartException {
		service.removeCart(cartID);
		return new EcomerceMessage(EcommerceConstants.CART_REMOVED);
	}

	@CrossOrigin
	@PostMapping(path ="addOrder/{userid}")
	public EcomerceMessage addOrder(@PathVariable("userid") String userId, @RequestBody Address address) throws NoCartException, NoProductException {
		service.addOrder(userId, address);
		return new EcomerceMessage(EcommerceConstants.ORDER_PLACED);
	}
}
