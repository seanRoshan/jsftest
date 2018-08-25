package org.ocpc.ecommerce.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.ocpc.ecommerce.model.Product;
import org.ocpc.ecommerce.service.ProductManager;

@ManagedBean(name="ProductView")
@ViewScoped
public class ProductView {
	
	private Product[] products;
	
	@ManagedProperty("#{productManagerService}")
	private ProductManager productService;
	
	@PostConstruct
	public void init() {
		products = productService.getAllProducts();
	}

	public ProductManager getProductService() {
		return productService;
	}

	public void setProductService(ProductManager productService) {
		this.productService = productService;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}
	
}
