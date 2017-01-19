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


/**
 * The Class RegisterAction.
 */
public class RegisterAction extends ActionSupport{
	
	/** The type select. */
	String typeSelect;
	
	/** The username. */
	String username;
	
	/** The password. */
	String password;
	
	/** The telephone. */
	String telephone;
	
	/** The email. */
	String email;
	
	/** The airline. */
	String airline;
	
	/** The airport. */
	String airport;
	
	/** The airline list. */
	List<Airline> airlineList;
	
	/** The airport list. */
	List<Airport> airportList;
	
	/** The dao airline. */
	DaoAirline daoAirline;
	
	/** The dao airport. */
	DaoAirport daoAirport;
	
	/** The dao user. */
	DaoUser daoUser;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
        return "success";
    }
	
	/**
	 * Register.
	 *
	 * @return the string
	 */
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
	
	/**
	 * Register passenger.
	 *
	 * @return true, if successful
	 */
	public boolean registerPassenger(){
		boolean result  = false;
		
		result = daoUser.registerPassenger(username, password, telephone, email);
		
		return result;		
	}
	
	/**
	 * Register airline user.
	 *
	 * @return true, if successful
	 */
	public boolean registerAirlineUser(){
		boolean result  = false;
		
		result = daoUser.registerAirlineUser(username, password, Integer.valueOf(airline));
		
		return result;		
	}
	
	/**
	 * Register airport controller.
	 *
	 * @return true, if successful
	 */
	public boolean registerAirportController(){
		boolean result  = false;
		
		result = daoUser.registerAirportController(username, password, Integer.valueOf(airport));
		
		return result;		
	}
	
	/**
	 * Gets the airlines.
	 *
	 * @return the airlines
	 */
	public List<Airline> getAirlines(){
		daoAirline = new DaoAirline();
		airlineList = daoAirline.loadAirlines();
		
		return airlineList;
	}
	
	/**
	 * Gets the airports.
	 *
	 * @return the airports
	 */
	public List<Airport> getAirports(){
		daoAirport = new DaoAirport();
		airportList = daoAirport.loadAirports();
		
		return airportList;
	}

	/**
	 * Gets the type select.
	 *
	 * @return the type select
	 */
	public String getTypeSelect() {
		return typeSelect;
	}

	/**
	 * Sets the type select.
	 *
	 * @param typeSelect the new type select
	 */
	public void setTypeSelect(String typeSelect) {
		this.typeSelect = typeSelect;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the telephone.
	 *
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Sets the telephone.
	 *
	 * @param telephone the new telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the airline.
	 *
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}

	/**
	 * Sets the airline.
	 *
	 * @param airline the new airline
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}

	/**
	 * Gets the airport.
	 *
	 * @return the airport
	 */
	public String getAirport() {
		return airport;
	}

	/**
	 * Sets the airport.
	 *
	 * @param airport the new airport
	 */
	public void setAirport(String airport) {
		this.airport = airport;
	}

	/**
	 * Gets the airline list.
	 *
	 * @return the airline list
	 */
	public List<Airline> getAirlineList() {
		return airlineList;
	}

	/**
	 * Sets the airline list.
	 *
	 * @param airlineList the new airline list
	 */
	public void setAirlineList(List<Airline> airlineList) {
		this.airlineList = airlineList;
	}

	/**
	 * Gets the airport list.
	 *
	 * @return the airport list
	 */
	public List<Airport> getAirportList() {
		return airportList;
	}

	/**
	 * Sets the airport list.
	 *
	 * @param airportList the new airport list
	 */
	public void setAirportList(List<Airport> airportList) {
		this.airportList = airportList;
	}
	
	

}
