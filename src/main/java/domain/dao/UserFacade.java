package domain.dao;


import domain.model.User;

/**
 * The facade of the project.
 * @author PBL5
 *
 */
public class UserFacade {

    /**
     * Is the user that is going to enter in the database.
     */
    private DaoUser daoUser = null;

    /**
     * Is the constructor.
     */
    public UserFacade() {
        //login = new DaoLoginProperties();
        //daoUser = new DaoUserMySQL();
        daoUser = new DaoUserPostgreSQL();
    }

    /**
     * To load the user.
     * @param username the name of the user
     * @param password the password of the user
     * @return the user
     */
    public User loadUser(final String username, final String password) {
        return daoUser.loadUser(username, password);
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
