package org.ocpc.ecommerce.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.ocpc.ecommerce.model.Authentican;
import org.ocpc.ecommerce.model.User;
import org.ocpc.ecommerce.service.AuthenticationManager;

@ManagedBean
@ViewScoped
public class LoginView {

	private Authentican authentication;

	@ManagedProperty("#{authenticationManagerService}")
	private AuthenticationManager authenticationManagerService;
	
	public void authenticate() {

		boolean isAuthonticated = authenticationManagerService.isAuthenticationValid(authentication);

		if (isAuthonticated) {
			try {

				User newUser = new User();
				newUser.setFirstName("Iman");
				newUser.setLastName("Reihanian");
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", newUser);

				FacesContext.getCurrentInstance().getExternalContext().redirect("dashboard.xhtml");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "The credentila is invalid!"));
		}

	}
	
	public Authentican getAuthentication() {
		if (authentication == null) {
			authentication = new Authentican();
		}
		return authentication;
	}

	public void setAuthentication(Authentican authentication) {
		this.authentication = authentication;
	}
	
	
	public AuthenticationManager getAuthenticationManagerService() {
		return authenticationManagerService;
	}

	public void setAuthenticationManagerService(AuthenticationManager authenticationManagerService) {
		this.authenticationManagerService = authenticationManagerService;
	}

}
