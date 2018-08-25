package org.ocpc.ecommerce.service;

import java.math.BigDecimal;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.ocpc.ecommerce.model.Product;


@ManagedBean(name = "productManagerService")
@ApplicationScoped
public class ProductManager {
	
	private static Product[] productList = new Product[4];
	
	static {
		productList[0] = new Product(1, "ipad1", new BigDecimal("1000.00"), "Like a 1 computer. Unlike any computer.", 10);
		productList[1] = new Product(2, "ipad2", new BigDecimal("1200.00"), "Like a 2 computer. Unlike any computer.", 10);
		productList[2] = new Product(3, "ipad3", new BigDecimal("1300.00"), "Like a 3 computer. Unlike any computer.", 10);
		productList[3] = new Product(4, "ipad4", new BigDecimal("1400.00"), "Like a 4 computer. Unlike any computer.", 10);
	}
	
	public Product getProduct(int id) {
		return productList[id];
	}
	
	public Product[] getAllProducts() {
		return productList;
	}
	

}
