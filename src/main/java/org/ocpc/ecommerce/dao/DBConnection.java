package org.ocpc.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "ocpcDataBase")
@SessionScoped
public class DBConnection {

	public Connection getConnection() {
		Connection con = null;
		String url = "jdbc:postgresql://localhost/ocpc";
		String user = "drsvr";
		String password = "test";

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection completed!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return con;

	}

}
