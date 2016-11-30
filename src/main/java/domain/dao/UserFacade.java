package domain.dao;

import java.util.ArrayList;

import domain.model.User;

public class UserFacade {
	DaoUser daoUser = null;
	
	public UserFacade(){
		//login = new DaoLoginProperties();
		//daoUser = new DaoUserMySQL();
		daoUser = new DaoUserPostgreSQL();
	}
	
	public User loadUser(String username, String password){
		return daoUser.loadUser(username,password);
	}
	
	/*
	public User loadUser(int userId){
		return daoUser.loadUser(userId);
	}
	public ArrayList<User> loadUsers(){
		return daoUser.loadUsers();
	}
	public boolean insertarUser(User user){
		return daoUser.insertUser(user);		
	}
	public boolean updateUser(User user){
		return daoUser.updateUser(user);
	}
	public boolean deleteUser(int userId){
		return daoUser.deleteUser(userId);
	}
	*/
}
