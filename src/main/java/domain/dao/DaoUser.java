package domain.dao;
import domain.model.User;
    /**
     * Is the interface of the DaoUser.
     * @author PBL5.
     *
     */
    public interface DaoUser {
    //public boolean insertUser(User user);
    /**
     * Is the function to load the users.
     * @param username is the name of the user.
     * @param password is the password of the user.
     * @return the user.
     */
    User loadUser(String username, String password);
    //public User loadUser(int userId);
    //public ArrayList<User> loadUsers();
    //public boolean updateUser(User user);
    //public boolean deleteUser(int userId);
}
