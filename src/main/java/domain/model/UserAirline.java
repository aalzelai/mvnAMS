package domain.model;

/**
 * The class of the user airline.
 * @author PBL5
 *
 */
public class UserAirline extends User {

    /**
     * Is the name of the airline.
     */
    private String airlineName;

    /**
     * The constructor of the users.
     */
    public UserAirline() {
        super();
    }

    /**
     * The complete constructor of the user airline.
     * @param idUser is the id
     * @param username the name of the user
     * @param password the password of the user
     * @param userType the type of the user
     * @param airlineName the name of the airline
     */
    public UserAirline(final int idUser, final String username,
                       final String password, final String userType,
                       final String airlineName) {
        super(idUser, username, password, userType);
        this.airlineName = airlineName;
    }

    /**
     * Getter of the name of the airline.
     * @return the name of the airline
     */
    public String getAirlineName() {
        return airlineName;
    }

    /**
     * Setter of the name of the airline.
     * @param airlineName is the name of the airline
     */
    public void setAirlineName(final String airlineName) {
        this.airlineName = airlineName;
    }


}
