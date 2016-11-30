package domain.model;

public class User {
	int id_user;
	String username;
	String password;
	String user_type;
	
	public User(){ }

	public User(int id_user, String username, String password, String user_type) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.user_type = user_type;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
