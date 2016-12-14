package domain.model;

/**
 * The class of the users that are controllers.
 * @author PBL5
 *
 */
public class UserController extends User {

    /**
     * Is the name of the airport.
     */
    private String airport;

    /**
     * The general constructor of the users.
     */
    public UserController() {
       super();
    }

    /**
     * Is the full constructor of the user controller.
     * @param idUser the id of the user
     * @param username the name of the user
     * @param password the password of the user
     * @param userType the type of the user
     * @param airport the airport that the user is.
     */
    public UserController(final int idUser, final String username,
                          final String password, final String userType,
                          final String airport) {
        super(idUser, username, password, userType);
        this.airport = airport;
    }

    /**
     * Getter of the airport.
     * @return the name of the airport.
     */
    public String getAirport() {
        return airport;
    }

    /**
     * Setter of the airport.
     * @param airport is the name of the airport.
     */
    public void setAirport(final String airport) {
        this.airport = airport;
    }
}
