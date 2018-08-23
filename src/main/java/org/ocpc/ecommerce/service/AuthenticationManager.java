package org.ocpc.ecommerce.service;

import javax.faces.bean.ManagedBean;

import org.ocpc.ecommerce.model.Authentican;

@ManagedBean
public class AuthenticationManager {

	public boolean isAuthenticationValid(Authentican authentication) {
		
		return (authentication.getUsername().equals("iman") && authentication.getPassword().equals("1234"));
		
	}	
	
}
