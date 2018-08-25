package org.ocpc.ecommerce.service;

import java.io.IOException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.ocpc.ecommerce.model.Authentican;
import org.ocpc.ecommerce.model.User;

@ManagedBean(name = "authenticationManagerService")
@ApplicationScoped
public class AuthenticationManager {

	private void redirectIndex() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isAuthenticationValid(Authentican authentication) {
		return (authentication.getUsername().equals("iman") && authentication.getPassword().equals("1234"));
	}
	
	public void logout() {

		User sessionUser = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		if (sessionUser != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
		}
		redirectIndex();
	}

	
	public void checkSession(){
		User sessionUser = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		if (sessionUser == null) {
			redirectIndex();
		}
	}
	
	public User getSessionUser() {
		User sessionUser = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		if (sessionUser != null) {
			return sessionUser;
		}
		else {
			redirectIndex();
			return null;
		}
		
	}
	
	




	
	
	
	
	

}
