package struts.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.dao.DaoAirline;
import domain.dao.DaoAirport;
import domain.dao.DaoUser;
import domain.model.Airline;
import domain.model.Airport;


public class RegisterAction extends ActionSupport{
	String typeSelect;
	String username;
	String password;
	String telephone;
	String email;
	String airline;
	String airport;
	
	List<Airline> airlineList;
	List<Airport> airportList;
	
	DaoAirline daoAirline;
	DaoAirport daoAirport;
	DaoUser daoUser;
	
	public String execute() {
        return "success";
    }
	
	public String register(){
		boolean inserted = false;
		System.out.println(typeSelect);
		System.out.println(username);
		System.out.println(password);
		
		if(telephone != null){
			System.out.println(telephone);
		}
		if(email != null){
			System.out.println(email);
		}
		if(airline != null){
			System.out.println(airline);
		}
		if(airport != null){
			System.out.println(airport);
		}
		
		daoUser = new DaoUser();
		
		switch(typeSelect){
		case "Passenger":
			inserted = registerPassenger();
			break;
		case "Airline":
			inserted = registerAirlineUser();
			break;
		case "Control":
			inserted = registerAirportController();
			break;
		default:
			return "error";
		}
		
		if(inserted){
			System.out.println("Insertado bien");
		}else{
			System.out.println("Noooooo");
		}
		
		return "success";
	}
	
	public boolean registerPassenger(){
		boolean result  = false;
		
		result = daoUser.registerPassenger(username, password, telephone, email);
		
		return result;		
	}
	
	public boolean registerAirlineUser(){
		boolean result  = false;
		
		result = daoUser.registerAirlineUser(username, password, Integer.valueOf(airline));
		
		return result;		
	}
	
	public boolean registerAirportController(){
		boolean result  = false;
		
		result = daoUser.registerAirportController(username, password, Integer.valueOf(airport));
		
		return result;		
	}
	
	public List<Airline> getAirlines(){
		daoAirline = new DaoAirline();
		airlineList = daoAirline.loadAirlines();
		
		return airlineList;
	}
	
	public List<Airport> getAirports(){
		daoAirport = new DaoAirport();
		airportList = daoAirport.loadAirports();
		
		return airportList;
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

	public List<Airline> getAirlineList() {
		return airlineList;
	}

	public void setAirlineList(List<Airline> airlineList) {
		this.airlineList = airlineList;
	}

	public List<Airport> getAirportList() {
		return airportList;
	}

	public void setAirportList(List<Airport> airportList) {
		this.airportList = airportList;
	}
	
	

}
