package domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the flight_status database table.
 */
@Entity
@Table(name = "flight_status")
@NamedQuery(name = "FlightStatus.findAll",
            query = "SELECT f FROM FlightStatus f")
public class FlightStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The identifier of the status.
     */
    @Id
    @Column(name = "id_status")
    private Integer idStatus;

    /**
     * The description.
     */
    private String description;

    /**
     * bi-directional many-to-one association to Flight.
     */
    @OneToMany(mappedBy = "flightStatus")
    private List<Flight> flights;

    /**
     * Constructor.
     */
    public FlightStatus() {
    }

    /**
     * Getter of the status identifier.
     * @return the identifier.
     */
    public Integer getIdStatus() {
        return this.idStatus;
    }

    /**
     * Setter of the status identifier.
     * @param idStatus is the identifier.
     */
    public void setIdStatus(final Integer idStatus) {
        this.idStatus = idStatus;
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
     * Getter of the list of flights.
     * @return the list of flights.
     */
    public List<Flight> getFlights() {
        return this.flights;
    }

    /**
     * Setter of the list of the flights.
     * @param flights is the list of the flights.
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
        flight.setFlightStatus(this);

        return flight;
    }

    /**
     * Function to remove a flight from the list.
     * @param flight is the flight to remove.
     * @return the removed flight.
     */
    public Flight removeFlight(final Flight flight) {
        getFlights().remove(flight);
        flight.setFlightStatus(null);

        return flight;
    }

}