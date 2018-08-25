package org.ocpc.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.ocpc.ecommerce.dao.DBConnection;
import org.ocpc.ecommerce.model.Product;
import org.ocpc.ecommerce.service.ProductManager;


public class Main {
	
	private static ProductManager myService = new ProductManager();

	public static void main(String[] args) {
		
		Product[] products;
		products = myService.getAllProducts();
		
		DBConnection connection = new DBConnection();
		
		if (products!= null) {
			System.out.println("Length: "+products.length);
		}
		else {
			System.out.println("Something is wrong!");
		}
		
		
		
		try {
			Connection con = connection.getConnection(); 
			String stm = "INSERT INTO products( \"id\", \"name\", \"price\", \"description\", \"numofinventory\") VALUES (nextval('id_seq'),?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(stm);
			pst.setString(1, "ipad");
			pst.setDouble(2, 100.00);
			pst.setString(3, "ipad is from apple");
			pst.setInt(4, 10);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
