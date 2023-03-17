package com.example.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshop.dto.CartDto;
import com.example.bookshop.service.CartService;

@RestController
@CrossOrigin
@RequestMapping("/cart")
@PreAuthorize("hasRole('USER')")
public class CartController {
	
	@Autowired
	private CartService service;
	
	@PostMapping("/addCart/{bookId}/{quantity}/{userName}")
	public ResponseEntity<CartDto> addToCart(@PathVariable int bookId,@PathVariable int quantity,@PathVariable String userName){
		return new ResponseEntity<>(CartDto.toDto(service.addToCart(bookId, quantity, userName)), HttpStatus.OK);
	}
	
	@PutMapping("/emptyCart/{userName}")
	public ResponseEntity<CartDto> emptyCart(@PathVariable String userName){
		return new ResponseEntity<>(CartDto.toDto(service.emptyCart(userName)), HttpStatus.OK);
	}
	
	@GetMapping("/getCart/{userName}")
	public ResponseEntity<CartDto> getCart(@PathVariable String userName){
		return new ResponseEntity<>(CartDto.toDto(service.getCartByUserName(userName)), HttpStatus.OK);
	}
}
