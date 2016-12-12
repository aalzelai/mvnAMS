package domain.model;

/**
 * The general class of the users.
 * @author PBL5
 *
 */
public class User {

    /**
     * The id of the user.
     */
    private int idUser;

    /**
     * The username of the user.
     */
    private String username;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * The type of the user.
     */
    private String userType;

    /**
     * A constructor of the user.
     */
    public User() {

    }

    /**
     * The general constructor of the users.
     * @param idUser is the id of the user
     * @param username is the name of the user
     * @param password is the password of the user
     * @param userType is the type of the user
     */
    public User(final int idUser, final String username,
                final String password, final String userType) {
        super();
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    /**
     * Getter of the username.
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter of the username.
     * @param username is the username.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Getter of the password.
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter of the password.
     * @param password is the password.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Getter of the id.
     * @return the id of the user.
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Setter of the id.
     * @param idUser is the id of the user
     */
    public void setIdUser(final int idUser) {
        this.idUser = idUser;
    }

    /**
     * Getter of the userType.
     * @return the type of the user.
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Setter of the userType.
     * @param userType is the type of the user
     */
    public void setUserType(final String userType) {
        this.userType = userType;
    }

}
