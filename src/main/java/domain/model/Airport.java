package domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the airport database table.
 */
@Entity
@NamedQuery(name = "Airport.findAll", query = "SELECT a FROM Airport a")
public class Airport implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The id of the airport.
     */
    @Id
    @Column(name = "id_airport")
    private Integer idAirport;

    /**
     * The name of the airport.
     */
    private String name;

    /**
     * The column of the terminals.
     */
    @Column(name = "num_terminals")
    private Integer numTerminals;

    /**
     * Column of the position in x.
     */
    @Column(name = "pos_x")
    private double posX;

    /**
     * Column of the position in y.
     */
    @Column(name = "pos_y")
    private double posY;

    /**
     * bi-directional many-to-one association to Flight.
     */
    @OneToMany(mappedBy = "airport1")
    private List<Flight> flights1;

    /**
     * bi-directional many-to-one association to Flight.
     */
    @OneToMany(mappedBy = "airport2")
    private List<Flight> flights2;

    /**
     * bi-directional many-to-one association to Lane.
     */
    @OneToMany(mappedBy = "airport")
    private List<Lane> lanes;

    /**
     * bi-directional many-to-one association to UserAirportController.
     */
    @OneToMany(mappedBy = "airport")
    private List<UserAirportController> userAirportControllers;

    /**
     * Constructor.
     */
    public Airport() {
    }

    /**
     * Getter of the Airport id.
     * @return the id.
     */
    public Integer getIdAirport() {
        return this.idAirport;
    }

    /**
     * Setter of the id of the airport.
     * @param idAirport is the identificator.
     */
    public void setIdAirport(final Integer idAirport) {
        this.idAirport = idAirport;
    }

    /**
     * Getter of the name of the airport.
     * @return the name of the airport.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter of the name of the airport.
     * @param name is the name of the airport.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter of the number of terminals.
     * @return the number of terminals.
     */
    public Integer getNumTerminals() {
        return this.numTerminals;
    }

    /**
     * Setter of the number of terminals.
     * @param numTerminals the number of terminals.
     */
    public void setNumTerminals(final Integer numTerminals) {
        this.numTerminals = numTerminals;
    }

    /**
     * Getter of the position in x.
     * @return the position in x.
     */
    public double getPosX() {
        return this.posX;
    }

    /**
     * Setter of the position in x.
     * @param posX the position in x.
     */
    public void setPosX(final double posX) {
        this.posX = posX;
    }

    /**
     * Getter of the position in y.
     * @return the position in y.
     */
    public double getPosY() {
        return this.posY;
    }

    /**
     * Setter of the position in y.
     * @param posY the position in y.
     */
    public void setPosY(final double posY) {
        this.posY = posY;
    }

    /**
     * Getter of the list of the flights.
     * @return the list of the flights.
     */
    public List<Flight> getFlights1() {
        return this.flights1;
    }

    /**
     * Setter of the list of the flights.
     * @param flights1 is the list of the flights.
     */
    public void setFlights1(final List<Flight> flights1) {
        this.flights1 = flights1;
    }

    /**
     * Function to add a flight to the list 1.
     * @param flights1 the flight to add.
     * @return the flight to add.
     */
    public Flight addFlights1(final Flight flights1) {
        getFlights1().add(flights1);
        flights1.setAirport1(this);

        return flights1;
    }

    /**
     * Function to remove a flight from the list.
     * @param flights1 is the flight to remove.
     * @return the flight to remove.
     */
    public Flight removeFlights1(final Flight flights1) {
        getFlights1().remove(flights1);
        flights1.setAirport1(null);

        return flights1;
    }

    /**
     * Getter of the list of the flights2.
     * @return the list of the flights2.
     */
    public List<Flight> getFlights2() {
        return this.flights2;
    }

    /**
     * Setter of the list of the flights2.
     * @param flights2 is the list of the flights2.
     */
    public void setFlights2(final List<Flight> flights2) {
        this.flights2 = flights2;
    }

    /**
     * Function to add a flight to the list 2.
     * @param flights2 the flight to add.
     * @return the added flight.
     */
    public Flight addFlights2(final Flight flights2) {
        getFlights2().add(flights2);
        flights2.setAirport2(this);

        return flights2;
    }

    /**
     * Function to remove a flight from the list 2.
     * @param flights2 the flight to remove.
     * @return the removed flight.
     */
    public Flight removeFlights2(final Flight flights2) {
        getFlights2().remove(flights2);
        flights2.setAirport2(null);

        return flights2;
    }

    /**
     * Getter of the lanes.
     * @return the lanes.
     */
    public List<Lane> getLanes() {
        return this.lanes;
    }

    /**
     * Setter of the lanes.
     * @param lanes the list of the lanes.
     */
    public void setLanes(final List<Lane> lanes) {
        this.lanes = lanes;
    }

    /**
     * Function to add a lane to the list.
     * @param lane the lane to add.
     * @return the added lane.
     */
    public Lane addLane(final Lane lane) {
        getLanes().add(lane);
        lane.setAirport(this);

        return lane;
    }

    /**
     * Function to remove a lane from the list.
     * @param lane the lane to remove.
     * @return the removed lane.
     */
    public Lane removeLane(final Lane lane) {
        getLanes().remove(lane);
        lane.setAirport(null);

        return lane;
    }

    /**
     * Getter of the controllers.
     * @return the list of the controllers.
     */
    public List<UserAirportController> getUserAirportControllers() {
        return this.userAirportControllers;
    }

    /**
     * Setter of the list of controllers of the airport.
     * @param userAirportControllers the list of controllers.
     */
    public void setUserAirportControllers(
                final List<UserAirportController> userAirportControllers) {
        this.userAirportControllers = userAirportControllers;
    }

    /**
     * Function to add a controller to the list.
     * @param userAirportController is the user to add.
     * @return the added user.
     */
    public UserAirportController addUserAirportController(
                 final UserAirportController userAirportController) {
        getUserAirportControllers().add(userAirportController);
        userAirportController.setAirport(this);

        return userAirportController;
    }

    /**
     * Function to remove a controller from the list.
     * @param userAirportController is the user to remove.
     * @return the removed user.
     */
    public UserAirportController removeUserAirportController(
                 final UserAirportController userAirportController) {
        getUserAirportControllers().remove(userAirportController);
        userAirportController.setAirport(null);

        return userAirportController;
    }

}