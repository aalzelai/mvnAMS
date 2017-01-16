package struts.action;

import java.util.List;
import java.util.Map;

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

    /**
     * The execute function.
     * @return the answer.
     */
    public String execute() {
    	System.out.println("Hola1");
    	Map<String, Object> session = ActionContext.getContext().getSession();
    	
    	System.out.println("Hola2");
        flightDao = new DaoFlight();
    	
        System.out.println("Hola3");
        flightList = flightDao.loadFlights();
    	
        System.out.println("Hola4");
        session.put("flightList", flightList);
        
    	System.out.println("Hola5");

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

}
