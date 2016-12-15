package struts.action;

import java.util.List;

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
     * The user.
     */
    private Flight user;

    /**
     * The list of the flights.
     */
    private List<Flight> flightList;

    /**
     * The flight dao.
     */
    private DaoFlight flightDao;

    /**
     * The execute function.
     * @return the answer.
     */
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

    /**
     * Getter of the user.
     * @return the user.
     */
    public Flight getUser() {
        return user;
    }

    /**
     * Setter of the user.
     * @param user is the user.
     */
    public void setUser(final Flight user) {
        this.user = user;
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
