package struts.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;


public class RegisterAction extends ActionSupport{
	String typeSelect;
	String username;
	String password;
	String telephone;
	String email;
	String airline;
	String airport;
	
	public String execute() {
        return "success";
    }
	
	public String register(){
		System.out.println(typeSelect);
		System.out.println(username);
		System.out.println(password);
		System.out.println(telephone);
		System.out.println(email);
		System.out.println(airline);
		System.out.println(airport);
		return "success";
	}

	public String getTypeSelect() {
		return typeSelect;
	}

	public void setTypeSelect(String typeSelect) {
		this.typeSelect = typeSelect;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}
	
	

}
