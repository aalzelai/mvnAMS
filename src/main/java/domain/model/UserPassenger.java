package domain.model;

/**
 * The class of the users that are passengers.
 * @author mikel
 *
 */
public class UserPassenger extends User {

    /**
     * The telephone of the user.
     */
    private String telephone;

    /**
     * The email of the user.
     */
    private String email;

    /**
     * The general constructor of the users.
     */
    public UserPassenger() {
        super();
    }

    /**
     * The full constructor of the passengers.
     * @param idUser the id of the user
     * @param username the name of the user
     * @param password the password of the user
     * @param userType the type of the user
     * @param telephone the telephone of the user
     * @param email the email of the user
     */
    public UserPassenger(final int idUser, final String username,
                        final String password, final String userType,
                        final String telephone, final String email) {
        super(idUser, username, password, userType);
        this.telephone = telephone;
        this.email = email;
    }

    /**
     * Getter of the telephone of the user.
     * @return the telephone of the user.
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Setter of the telephone of the user.
     * @param telephone is the telephone of the user
     */
    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    /**
     * Getter of the email of the user.
     * @return the email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter of the email of the user.
     * @param email is the email of the user.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

}
