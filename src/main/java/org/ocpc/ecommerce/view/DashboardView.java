package org.ocpc.ecommerce.view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.ocpc.ecommerce.model.User;
import org.ocpc.ecommerce.service.AuthenticationManager;

@ManagedBean
@ViewScoped
public class DashboardView {

	private boolean[] dashBoardViews = new boolean[5];
	private boolean initMessage;

	@ManagedProperty("#{authenticationManagerService}")
	private AuthenticationManager authenticationManagerService;

	@PostConstruct
	public void init(ComponentSystemEvent test) {
		authenticationManagerService.checkSession();
		if (!this.initMessage) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Hello "+ this.authenticationManagerService.getSessionUser().getFirstName() +"!", "Welcome to the Dashboard!"));
			this.initMessage = true;
			dashBoardViews[0] = true;
		}
	}

	public void showHome() {
		this.dashBoardViews = new boolean[5];
		this.dashBoardViews[0] = true;
	}

	public boolean getWelcomeRender() {
		return dashBoardViews[0];
	}

	public boolean getShowProfileRender() {
		return dashBoardViews[1];
	}

	public void showProfile() {
		this.dashBoardViews = new boolean[5];
		this.dashBoardViews[1] = true;
	}

	public boolean getEditProfileRender() {
		return dashBoardViews[2];
	}

	public void showEditProfile() {
		this.dashBoardViews = new boolean[5];
		this.dashBoardViews[2] = true;
	}

	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved!", "Your profile has been updated!"));
	}

	public boolean getshowProductsRender() {
		return dashBoardViews[3];
	}

	public void showProducts() {
		this.dashBoardViews = new boolean[5];
		this.dashBoardViews[3] = true;
	}

	public void logout() {
		authenticationManagerService.logout();
	}

	public User getUser() {
		return authenticationManagerService.getSessionUser();
	}

	public AuthenticationManager getAuthenticationManagerService() {
		return authenticationManagerService;
	}

	public void setAuthenticationManagerService(AuthenticationManager authenticationManagerService) {
		this.authenticationManagerService = authenticationManagerService;
	}

}
