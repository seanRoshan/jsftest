package org.ocpc.ecommerce.model;

import java.math.BigDecimal;

public class Product {
	
	private int id;
	private String name;
	private BigDecimal price;
	private String description;
	private int numOfInventory;
	
	public Product(int id, String name, BigDecimal price, String description, int numOfInventory) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.numOfInventory = numOfInventory;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumOfInventory() {
		return numOfInventory;
	}
	public void setNumOfInventory(int numOfInventory) {
		this.numOfInventory = numOfInventory;
	}
	
	
	
}
