package org.ocpc.ecommerce.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.ocpc.ecommerce.model.User;

@ManagedBean
@SessionScoped
public class DashboardView {
	
	private User user;
	
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Saved!","Your profile has been updated!"));
	}

	public void init(ComponentSystemEvent test) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Hello!","Welcome to the Dashboard!"));
	}
	
	public User getUser() {
		
		User sessionUser = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		if (sessionUser==null) {
			System.out.println("Created a new user!");
			user = new User();
			user.setFirstName("iman");
			user.setLastName("reihanian");
		}
		else {
			this.setUser(sessionUser);
		}
		
		
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
