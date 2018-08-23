package org.ocpc.ecommerce.model;

public class Product {
	
	private int id;
	private String name;
	private int price;
	private String description;
	private int numOfInventory;
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
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
