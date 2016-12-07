package domain.model;

public class User_Controller extends User{

	String airport;
	
	public User_Controller(){
		super();
	}
	
	public User_Controller(int id_user, String username,
			String password, String user_type, String airport){
		super(id_user, username, password, user_type);
		this.airport = airport;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}
	
	
}
