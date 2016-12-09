package domain.model;

import java.sql.Timestamp;

public class Flight {
	Timestamp time_In;
	Timestamp time_Out;
	String airport_In;
	String airport_Out;
	int delay;
	String estate;
	int number_Port;
	int number_Luggage;
	int id;
	Airplane airplane;
	
	public Flight(int id, Airplane airplane, String estate,
				Timestamp time_In, Timestamp time_Out,
				String airport_In, String airport_Out,
				int delay, int number_Port, int number_Luggage){
		
		this.id = id;
		this.airplane = airplane;
		this.estate = estate;
		this.time_In = time_In;
		this.time_Out = time_Out;
		this.airport_In = airport_In;
		this.airport_Out = airport_Out;
		this.delay = delay;
		this.number_Port = number_Port;
		this.number_Luggage = number_Luggage;
	}

	public Timestamp getTime_In() {
		return time_In;
	}

	public void setTime_In(Timestamp time_In) {
		this.time_In = time_In;
	}

	public Timestamp getTime_Out() {
		return time_Out;
	}

	public void setTime_Out(Timestamp time_Out) {
		this.time_Out = time_Out;
	}

	public String getAirport_In() {
		return airport_In;
	}

	public void setAirport_In(String airport_In) {
		this.airport_In = airport_In;
	}

	public String getAirport_Out() {
		return airport_Out;
	}

	public void setAirport_Out(String airport_Out) {
		this.airport_Out = airport_Out;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public String getEstate() {
		return estate;
	}

	public void setEstate(String estate) {
		this.estate = estate;
	}

	public int getNumber_Port() {
		return number_Port;
	}

	public void setNumber_Port(int number_Port) {
		this.number_Port = number_Port;
	}

	public int getNumber_Luggage() {
		return number_Luggage;
	}

	public void setNumber_Luggage(int number_Luggage) {
		this.number_Luggage = number_Luggage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	
	
}
