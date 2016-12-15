package domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_airport_controller database table.
 */
@Entity
@Table(name = "user_airport_controller")
@NamedQuery(name = "UserAirportController.findAll",
            query = "SELECT u FROM UserAirportController u")
public class UserAirportController implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The identifier.
     */
    @Id
    @Column(name = "id_user")
    private Integer idUser;

    /**
     * The password.
     */
    private String password;

    /**
     * The username.
     */
    private String username;

    /**
     * bi-directional many-to-one association to UserType.
     */
    @ManyToOne
    @JoinColumn(name = "id_user_type")
    private UserType userType;

    /**
     * bi-directional many-to-one association to Airport.
     */
    @ManyToOne
    @JoinColumn(name = "id_airport")
    private Airport airport;

    /**
     * Constructor.
     */
    public UserAirportController() {
    }

    /**
     * Getter of the identifier.
     * @return the identifier.
     */
    public Integer getIdUser() {
        return this.idUser;
    }

    /**
     * Setter of the identifier.
     * @param idUser is the identifier.
     */
    public void setIdUser(final Integer idUser) {
        this.idUser = idUser;
    }

    /**
     * Getter of the password.
     * @return the password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter of the password.
     * @param password is the password.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Getter of the username.
     * @return the username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Setter of the username.
     * @param username is the username.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Getter of the user type.
     * @return the user type.
     */
    public UserType getUserType() {
        return this.userType;
    }

    /**
     * Setter of the user type.
     * @param userType is the user type.
     */
    public void setUserType(final UserType userType) {
        this.userType = userType;
    }

    /**
     * Getter of the airport.
     * @return the airport.
     */
    public Airport getAirport() {
        return this.airport;
    }

    /**
     * Setter of the airport.
     * @param airport is the airport.
     */
    public void setAirport(final Airport airport) {
        this.airport = airport;
   }

}