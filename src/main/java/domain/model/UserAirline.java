package domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_airline database table.
 */
@Entity
@Table(name = "user_airline")
@NamedQuery(name = "UserAirline.findAll", query = "SELECT u FROM UserAirline u")
public class UserAirline implements Serializable {
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
     * bi-directional many-to-one association to Airline.
     */
    @ManyToOne
    @JoinColumn(name = "id_airline")
    private Airline airline;

    /**
     * Constructor.
     */
    public UserAirline() {
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
     * Getter of the airline.
     * @return the airline.
     */
    public Airline getAirline() {
        return this.airline;
    }

    /**
     * Setter of the airline.
     * @param airline is the airline.
     */
    public void setAirline(final Airline airline) {
        this.airline = airline;
    }

}
