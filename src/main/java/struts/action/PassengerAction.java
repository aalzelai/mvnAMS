package struts.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.dao.*;
import domain.model.*;

/**
 * Class passenger action.
 * @author mPBL5.
 *
 */
public class PassengerAction extends ActionSupport {

    /**
     * The serial version.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The list of the flights.
     */
    private List<Flight> flightList;

    /**
     * The flight dao.
     */
    private DaoFlight flightDao;
    
    private DaoUser daoUser;
    private String username;
    private String password;
    private String telephone;
    private String email;

    /**
     * The execute function.
     * @return the answer.
     */
    public String execute() {
    	Map<String, Object> session = ActionContext.getContext().getSession();
    	
        flightDao = new DaoFlight();
        flightList = flightDao.loadFlights();
    	
        session.put("flightList", flightList);
        
        return "success";
    }
    
    public String seeProfile(){
    	return "success";
    }
    
    public String removeAndDeleteUser(){
    	Map<String, Object> session = ActionContext.getContext().getSession();
    	Object user = session.get("user");
    	boolean removed = false;
    	
    	daoUser = new DaoUser();
    	removed = daoUser.deleteUser(user);
    	
    	if(removed){
    		session.remove("user");
    	}
    	
    	return "success";
    }
    
    public String editUser(){    	
    	HttpServletRequest request = ServletActionContext.getRequest();
    	request.setAttribute("edit", true);
    	
    	return "success";
    }
    
    public String saveEditedUser(){
    	Map<String, Object> session = ActionContext.getContext().getSession();
    	Object user = session.get("user");
    	boolean edited = false;
    	
    	if(user instanceof UserPassenger){
    		UserPassenger userPassenger = (UserPassenger) user;
    		userPassenger.setUsername(username);
    		userPassenger.setPassword(password);
    		userPassenger.setTelephone(telephone);
    		userPassenger.setEmail(email);
    		System.out.println("Estoy en pass editar");
    	}
    	
    	if(user instanceof UserAirline){
    		UserAirline userAirline = (UserAirline) user;
    		userAirline.setUsername(username);
    		userAirline.setPassword(password);
    		System.out.println("Estoy en airline editar");
    	}
    	
    	if(user instanceof UserAirportController){
    		UserAirportController userAirportController = (UserAirportController) user;
    		userAirportController.setUsername(username);
    		userAirportController.setPassword(password);
    		System.out.println("Estoy en airport editar");
    	}
    	
    	daoUser = new DaoUser();
    	edited = daoUser.saveEditedUser(user);
    	
    	if(edited){
    		session.replace("user", user);
    	}
    	
    	return "success";
    }

    /**
     * Getter of the flight dao.
     * @return the flight dao.
     */
    public DaoFlight getFlightDao() {
        return flightDao;
    }

    /**
     * Setter of the flight dao.
     * @param flightDao is the flight dao
     */
    public void setFlightDao(final DaoFlight flightDao) {
        this.flightDao = flightDao;
    }

    /**
     * Getter of the list of flights.
     * @return the list of the flihgts.
     */
    public List<Flight> getFlightList() {
        return flightList;
    }

    /**
     * Setter of the list of the flights.
     * @param flightList is the list of the flights.
     */
    public void setFlightList(final List<Flight> flightList) {
        this.flightList = flightList;
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

    
    
}
