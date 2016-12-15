package struts.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import domain.dao.*;
import domain.model.*;

public class PassengerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Flight user;
	private List<Flight> flightList;
	private DaoFlight flightDao;
	
	public String execute() {
		 
		/*System.out.println("Username: "+user.getUsername());
		System.out.println("Password: "+user.getPassword());
		
		if(user.getUsername()!=null && user.getPassword()!=null){
			
		}*/
    	
		flightDao = new DaoFlight();
    	
    	
		flightList = flightDao.loadFlights();		
    	System.out.println("success");

		return "success";
		
    }

	public Flight getUser() {
		return user;
	}

	public void setUser(Flight user) {
		this.user = user;
	}

	public DaoFlight getFlightDao() {
		return flightDao;
	}

	public void setFlightDao(DaoFlight flightDao) {
		this.flightDao = flightDao;
	}

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}
	
}
