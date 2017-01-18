package struts.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import domain.dao.DaoFlight;
import domain.model.Flight;

public class PassengerControllerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * The flight dao.
     */
    private DaoFlight flightDao;
    
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


	/**
     * The list of the flights.
     */
    private List<Flight> flightList;
    
    
	/**
     * The execute function.
     * @return the answer.
     */
    public String execute() {


       // flightDao = new DaoFlight();
        //Flight f;

        //setFlightList(flightDao.loadFlights());
        
       // for(int i = 0 ; i < flightList.size(); i++){
        	
        //}
        return "success";

    }

}
