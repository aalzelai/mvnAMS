package struts.action;

import java.util.ArrayList;
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
        	data = data + ""+f.getIdFlight()+"$"+f.getAirport1().getPosX()+"/"+f.getAirport1().getPosY()+"$"+f.getPlane().getPosX()+"/"+f.getPlane().getPosY()+"$"+f.getPlane().getAngle()+"%";
        }
        data = data + "'";
        return "success";

    }

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
