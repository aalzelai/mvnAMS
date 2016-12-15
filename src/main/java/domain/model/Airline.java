package domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the airline database table.
 *
 */
@Entity
@NamedQuery(name = "Airline.findAll", query = "SELECT a FROM Airline a")
public class Airline implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Column id airline.
     */
    @Id
    @Column(name = "id_airline")
    private Integer idAirline;

    /**
     * The name.
     */
    private String name;

    /**
     * bi-directional many-to-one association to Plane.
     */
    @OneToMany(mappedBy = "airline")
    private List<Plane> planes;

    /**
     * bi-directional many-to-one association to UserAirline.
     */
    @OneToMany(mappedBy = "airline")
    private List<UserAirline> userAirlines;

    /**
     * Constructor.
     */
    public Airline() {
    }

    /**
     * Getter of the idAirline.
     * @return the id.
     */
    public Integer getIdAirline() {
        return this.idAirline;
    }

    /**
     * Setter of id airline.
     * @param idAirline is the id.
     */
    public void setIdAirline(final Integer idAirline) {
        this.idAirline = idAirline;
    }

    /**
     * Getter of the name of the airline.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter of the name of the airline.
     * @param name is the name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter of the list of the planes of the airline.
     * @return the list.
     */
    public List<Plane> getPlanes() {
        return this.planes;
    }

    /**
     * Setter of the planes of the airline.
     * @param planes is the list.
     */
    public void setPlanes(final List<Plane> planes) {
        this.planes = planes;
    }

    /**
     * Function to add a plane.
     * @param plane the new plane
     * @return the plane
     */
    public Plane addPlane(final Plane plane) {
        getPlanes().add(plane);
        plane.setAirline(this);

        return plane;
    }

    /**
     * Function to remove a plane.
     * @param plane is the plane to remove
     * @return the plane
     */
    public Plane removePlane(final Plane plane) {
        getPlanes().remove(plane);
        plane.setAirline(null);

        return plane;
    }

    /**
     * Getter of the users of the airline.
     * @return the list of users.
     */
    public List<UserAirline> getUserAirlines() {
        return this.userAirlines;
    }

    /**
     * Setter of the list of the users of an airline.
     * @param userAirlines is the list.
     */
    public void setUserAirlines(final List<UserAirline> userAirlines) {
        this.userAirlines = userAirlines;
    }

    /**
     * Function to add a user to the list of the users.
     * @param userAirline the new user.
     * @return the user.
     */
    public UserAirline addUserAirline(final UserAirline userAirline) {
        getUserAirlines().add(userAirline);
        userAirline.setAirline(this);

        return userAirline;
    }

    /**
     * Function to remove a user from the list.
     * @param userAirline the user to remove.
     * @return the user.
     */
    public UserAirline removeUserAirline(final UserAirline userAirline) {
        getUserAirlines().remove(userAirline);
        userAirline.setAirline(null);

        return userAirline;
    }

}