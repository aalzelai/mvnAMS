package domain.dao;
import domain.model.User;

public interface DaoUser {
	//public boolean insertUser(User user);
	public User loadUser(String username,String password);
	//public User loadUser(int userId);
	//public ArrayList<User> loadUsers();
	//public boolean updateUser(User user);
	//public boolean deleteUser(int userId);
}
