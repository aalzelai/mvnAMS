package domain.model;

public class User_Passenger extends User {
	String telephone;
	String email;
	
	

	public User_Passenger() {
		super();
	}

	public User_Passenger(int id_user, String username, String password, String user_type, String telephone,
			String email) {
		super(id_user, username, password, user_type);
		this.telephone = telephone;
		this.email = email;
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
