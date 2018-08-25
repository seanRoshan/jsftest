package org.ocpc.ecommerce;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.ocpc.ecommerce.model.Product;
import org.ocpc.ecommerce.service.ProductManager;


public class Main {
	
	private static ProductManager myService = new ProductManager();

	public static void main(String[] args) {
		
		Product[] products;
		products = myService.getAllProducts();
		
		if (products!= null) {
			System.out.println("Length: "+products.length);
		}
		else {
			System.out.println("Something is wrong!");
		}
		
	}
}
