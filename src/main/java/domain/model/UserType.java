package domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_type database table.
 */
@Entity
@Table(name = "user_type")
@NamedQuery(name = "UserType.findAll", query = "SELECT u FROM UserType u")
public class UserType implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The identifier.
     */
    @Id
    @Column(name = "id_user_type")
    private Integer idUserType;

    /**
     * The description.
     */
    private String description;

    /**
     * bi-directional many-to-one association to UserAirline.
     */
    @OneToMany(mappedBy = "userType")
    private List<UserAirline> userAirlines;

    /**
     * bi-directional many-to-one association to UserAirportController.
     */
    @OneToMany(mappedBy = "userType")
    private List<UserAirportController> userAirportControllers;

    /**
     * bi-directional many-to-one association to UserPassenger.
     */
    @OneToMany(mappedBy = "userType")
    private List<UserPassenger> userPassengers;

    /**
     * bi-directional many-to-one association to User.
     */
    @OneToMany(mappedBy = "userType")
    private List<User> users;

    /**
     * Constructor.
     */
    public UserType() {
    }

    /**
     * Getter of the identifier.
     * @return the identifier.
     */
    public Integer getIdUserType() {
        return this.idUserType;
    }

    /**
     * Setter of the identifier.
     * @param idUserType is the identifier.
     */
    public void setIdUserType(final Integer idUserType) {
        this.idUserType = idUserType;
    }

    /**
     * Getter of the description.
     * @return the description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter of the description.
     * @param description is the description.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Getter of the list of the user airline.
     * @return the user airline.
     */
    public List<UserAirline> getUserAirlines() {
        return this.userAirlines;
    }

    /**
     * Setter of the list of the users airline.
     * @param userAirlines is the list of the users airline.
     */
    public void setUserAirlines(final List<UserAirline> userAirlines) {
        this.userAirlines = userAirlines;
    }

    /**
     * Function to add a user to the list of user airline.
     * @param userAirline the user to add.
     * @return the added user.
     */
    public UserAirline addUserAirline(final UserAirline userAirline) {
        getUserAirlines().add(userAirline);
        userAirline.setUserType(this);

        return userAirline;
    }

    /**
     * Function to remove the user from the list of users airline.
     * @param userAirline is the user to remove.
     * @return the removed user.
     */
    public UserAirline removeUserAirline(final UserAirline userAirline) {
        getUserAirlines().remove(userAirline);
        userAirline.setUserType(null);

        return userAirline;
    }

    /**
     * Getter of the list of the users controllers.
     * @return the list of users controllers.
     */
    public List<UserAirportController> getUserAirportControllers() {
        return this.userAirportControllers;
    }

    /**
     * Setter of the list of the users controllers.
     * @param userAirportControllers is the list of the users controllers.
     */
    public void setUserAirportControllers(
            final List<UserAirportController> userAirportControllers) {
        this.userAirportControllers = userAirportControllers;
    }

    /**
     * Function to add a user to the list of the users controllers.
     * @param userAirportController is the user to add.
     * @return the added user.
     */
    public UserAirportController addUserAirportController(
            final UserAirportController userAirportController) {
        getUserAirportControllers().add(userAirportController);
        userAirportController.setUserType(this);

        return userAirportController;
    }

    /**
     * Function to remove a user from the list of the users controllers.
     * @param userAirportController is the user to remove.
     * @return the removed user.
     */
    public UserAirportController removeUserAirportController(
            final UserAirportController userAirportController) {
        getUserAirportControllers().remove(userAirportController);
        userAirportController.setUserType(null);

        return userAirportController;
    }

    /**
     * Getter of the list of the users passengers.
     * @return the list of the users passengers.
     */
    public List<UserPassenger> getUserPassengers() {
        return this.userPassengers;
    }

    /**
     * Setter of the list of the users passengers.
     * @param userPassengers is the list of the users passengers.
     */
    public void setUserPassengers(final List<UserPassenger> userPassengers) {
        this.userPassengers = userPassengers;
    }

    /**
     * Function to add a user to the list of users passengers.
     * @param userPassenger is the user to add.
     * @return is the added user.
     */
    public UserPassenger addUserPassenger(final UserPassenger userPassenger) {
        getUserPassengers().add(userPassenger);
        userPassenger.setUserType(this);

        return userPassenger;
    }

    /**
     * Function to remove a user from the list of the users passengers.
     * @param userPassenger is the user to add.
     * @return is the added user.
     */
    public UserPassenger removeUserPassenger(
             final UserPassenger userPassenger) {
        getUserPassengers().remove(userPassenger);
        userPassenger.setUserType(null);

        return userPassenger;
    }

    /**
     * Getter of the list of all the users.
     * @return the list of all the users.
     */
    public List<User> getUsers() {
        return this.users;
    }

    /**
     * Setter of the list of all the users.
     * @param users is the list of all the users.
     */
    public void setUsers(final List<User> users) {
        this.users = users;
    }

    /**
     * Function to add a user to the list of all the users.
     * @param user is the user to add.
     * @return is the added user.
     */
    public User addUser(final User user) {
        getUsers().add(user);
        user.setUserType(this);

        return user;
    }

    /**
     * Functiion to remove a user from the list of all the users.
     * @param user is the user to remove.
     * @return is the removed user.
     */
    public User removeUser(final User user) {
        getUsers().remove(user);
        user.setUserType(null);

        return user;
    }

}