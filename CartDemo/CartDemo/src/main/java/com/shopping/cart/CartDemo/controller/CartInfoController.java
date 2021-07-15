package com.shopping.cart.CartDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.CartDemo.Response.CartResponseInfo;
import com.shopping.cart.CartDemo.model.CartRequestInfo;
import com.shopping.cart.CartDemo.service.CartService;

@RestController
@RequestMapping("/api/v1.0/shoppingCart")
public class CartInfoController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/creation")
	public ResponseEntity<CartResponseInfo> createCart(@RequestBody CartRequestInfo cartRequestInfo) {
		
		return cartService.cartCreation(cartRequestInfo);
		
	}
	
	@GetMapping("/retrieve/{ordNo}")
	public ResponseEntity<CartResponseInfo> retrieve(@PathVariable String ordNo) {
		
		return cartService.retreive(ordNo);
		
	}
	
	@PutMapping("/modification/{ordNo}")
	public ResponseEntity<CartResponseInfo> modification(@RequestBody CartRequestInfo cartRequestInfo,@PathVariable String ordNo) {
		return cartService.modification(ordNo, cartRequestInfo);
		
	}
	

}
