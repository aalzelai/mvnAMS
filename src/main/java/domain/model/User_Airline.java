package domain.model;

public class User_Airline extends User{
	String airline_name;
	
	public User_Airline(){
		super();
	}
	
	public User_Airline(int id_user, String username, String password,
						String user_type, String airline_name){
		super(id_user, username, password, user_type);
		this.airline_name = airline_name;
	}
	
	public String getAirline_name() {
		return airline_name;
	}

	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}
}
