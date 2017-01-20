package struts.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import domain.dao.DaoFlight;
import domain.model.Flight;

/**
 * The Class MapAction.
 */
public class MapAction  extends ActionSupport{

	/** The Constant serialVersionUID. */
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
     * The data of the flights.
     */
    private String data ="'";
    
	/**
     * The execute function.
     * @return the answer.
     */
    public String execute() {


        flightDao = new DaoFlight();
        Flight f;

        setFlightList(flightDao.loadFlights());
        
        for(int i = 0 ; i < flightList.size(); i++){
        	f = flightList.get(i);
        	data = data + ""+f.getPlane().getAirline().getIdAirline() + "$"+f.getPlane().getPosX()+"/"+f.getPlane().getPosY()+"$"+f.getPlane().getAngle()+"%";
        }
        data = data + "'";
        System.out.println(data);
        return "success";

    }
    
    /**
     * Gets the flight data.
     *
     * @return the flight data
     */
    public String getFlightData(){
    	flightDao = new DaoFlight();
    	data = "";
        Flight f;
        
        setFlightList(flightDao.loadFlights());
        
        for(int i = 0 ; i < flightList.size(); i++){
        	f = flightList.get(i);
        	data = data + ""+f.getPlane().getAirline().getIdAirline() + "$"+f.getPlane().getPosX()+"/"+f.getPlane().getPosY()+"$"+f.getPlane().getAngle()+"%";
        }
    	
    	return data;
    }

	/**
	 * Gets the flight list.
	 *
	 * @return the flight list
	 */
	public List<Flight> getFlightList() {
		return flightList;
	}

	/**
	 * Sets the flight list.
	 *
	 * @param flightList the new flight list
	 */
	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(String data) {
		this.data = data;
	}

}
