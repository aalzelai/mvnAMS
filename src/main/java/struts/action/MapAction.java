package struts.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import domain.dao.DaoFlight;
import domain.model.Flight;

public class MapAction  extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * The flight dao.
     */
    private DaoFlight flightDao;
    
    /**
     * The list of the flights.
     */
    private List<Flight> flightList;
    
	/**
     * The execute function.
     * @return the answer.
     */
    public String execute() {


        flightDao = new DaoFlight();

        setFlightList(flightDao.loadFlights());

        return "success";

    }

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}

	
}
