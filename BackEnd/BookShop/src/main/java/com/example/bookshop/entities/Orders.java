package com.example.bookshop.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

	@Id
	@GeneratedValue
	private int orderId;
	
	@OneToMany
	private List<Book> orderedBooks;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@NotNull
	private double amount;

	@ManyToOne(fetch = FetchType.EAGER)
	private Users user;

}
