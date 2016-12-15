package domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plane database table.
 */
@Entity
@NamedQuery(name = "Plane.findAll", query = "SELECT p FROM Plane p")
public class Plane implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The plane identifier.
     */
    @Id
    @Column(name = "id_plane")
    private Integer idPlane;

    /**
     * The plane position in x.
     */
    @Column(name = "pos_x")
    private double posX;

    /**
     * The plane position in y.
     */
    @Column(name = "pos_y")
    private double posY;

    /**
     * The terminal of the plane.
     */
    private Integer terminal;

    /**
     * bi-directional many-to-one association to Flight.
     */
    @OneToMany(mappedBy = "plane")
    private List<Flight> flights;

    /**
     * bi-directional many-to-one association to Airline.
     */
    @ManyToOne
    @JoinColumn(name = "id_airline")
    private Airline airline;

    /**
     * bi-directional many-to-one association to PlaneStatus.
     */
    @ManyToOne
    @JoinColumn(name = "id_status")
    private PlaneStatus planeStatus;

    /**
     * //bi-directional many-to-one association to PlaneType.
     */
    @ManyToOne
    @JoinColumn(name = "id_plane_type")
    private PlaneType planeType;

    /**
     * Constructor.
     */
    public Plane() {
    }

    /**
     * Getter of the identifier of the plane.
     * @return the identifier of the plane.
     */
    public Integer getIdPlane() {
        return this.idPlane;
    }

    /**
     * Setter of the identifier of the plane.
     * @param idPlane is the identifier of the plane.
     */
    public void setIdPlane(final Integer idPlane) {
        this.idPlane = idPlane;
    }

    /**
     * Getter of the position of the plane in x.
     * @return the position of the plane in x.
     */
    public double getPosX() {
        return this.posX;
    }

    /**
     * Setter of the position fo the plane in x.
     * @param posX is the position of the plane in x.
     */
    public void setPosX(final double posX) {
        this.posX = posX;
    }

    /**
     * Getter of the position of the plane in y.
     * @return the position of the plane in y.
     */
    public double getPosY() {
        return this.posY;
    }

    /**
     * Setter of the position of the plane in y.
     * @param posY is the position of the plane in y.
     */
    public void setPosY(final double posY) {
        this.posY = posY;
    }

    /**
     * Getter of the terminal.
     * @return the terminal.
     */
    public Integer getTerminal() {
        return this.terminal;
    }

    /**
     * Setter of the terminal.
     * @param terminal is the terminal.
     */
    public void setTerminal(final Integer terminal) {
        this.terminal = terminal;
    }

    /**
     * Getter of the list of flights of the plane.
     * @return the list of the flights.
     */
    public List<Flight> getFlights() {
        return this.flights;
    }

    /**
     * Setter of the list of the flight of the plane.
     * @param flights is the list of the flights of the plane.
     */
    public void setFlights(final List<Flight> flights) {
        this.flights = flights;
    }

    /**
     * Function to add a flight to the list.
     * @param flight is the flight to add.
     * @return the added flight.
     */
    public Flight addFlight(final Flight flight) {
        getFlights().add(flight);
        flight.setPlane(this);

        return flight;
    }

    /**
     * Function to remove a flight from the list.
     * @param flight is the flight to remove.
     * @return the removed flight.
     */
    public Flight removeFlight(final Flight flight) {
        getFlights().remove(flight);
        flight.setPlane(null);

        return flight;
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

    /**
     * Getter of the status of the plane.
     * @return the status of the plane.
     */
    public PlaneStatus getPlaneStatus() {
        return this.planeStatus;
    }

    /**
     * Setter of the status of the plane.
     * @param planeStatus is the status of the plane.
     */
    public void setPlaneStatus(final PlaneStatus planeStatus) {
        this.planeStatus = planeStatus;
    }

    /**
     * Getter of the type of the plane.
     * @return the type of the plane.
     */
    public PlaneType getPlaneType() {
        return this.planeType;
    }

    /**
     * Setter of the type of the plane.
     * @param planeType is the type of the plane.
     */
    public void setPlaneType(final PlaneType planeType) {
        this.planeType = planeType;
    }

}