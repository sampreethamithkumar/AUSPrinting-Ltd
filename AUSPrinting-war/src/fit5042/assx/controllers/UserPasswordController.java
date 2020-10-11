package fit5042.assx.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fit5042.assx.entities.Users;
import fit5042.assx.mbean.LoginController;

@ManagedBean(name = "userPasswordController")
@SessionScoped
public class UserPasswordController implements Serializable{

	@ManagedProperty(value = "#{loginController}")
	private LoginController loginController;
	
	private Users user;
	
	public Users getUser() {
		return loginController.getUser();
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
}
