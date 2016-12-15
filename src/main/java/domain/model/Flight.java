package domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the flight database table.
 * The class of the flight.
 * @author PBL5
 */
@Entity
@NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f")
public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The id of the flight.
     */
    @Id
    @Column(name = "id_flight")
    private Integer idFlight;

    /**
     * The number of the baggage.
     */
    @Column(name = "baggage_number")
    private Integer baggageNumber;

    /**
     * The date of the start point.
     */
    @Column(name = "date_time_from")
    private Timestamp dateTimeFrom;

    /**
     * The date of the final point.
     */
    @Column(name = "date_time_to")
    private Timestamp dateTimeTo;

    /**
     * The delay of the flight.
     */
    private Integer delay;

    /**
     * The number of the gate.
     */
    @Column(name = "gate_number")
    private Integer gateNumber;

    /**
     * The id of the airport of the start point.
     * bi-directional many-to-one association to Airport
     */
    @ManyToOne
    @JoinColumn(name = "id_airport_from")
    private Airport airport1;

    /**
     * The id of the airport of the final point.
     * bi-directional many-to-one association to Airport
     */
    @ManyToOne
    @JoinColumn(name = "id_airport_to")
    private Airport airport2;

    /**
     * The id of the status of the flight.
     * bi-directional many-to-one association to FlightStatus
     */
    @ManyToOne
    @JoinColumn(name = "id_status")
    private FlightStatus flightStatus;

    /**
     * The id of the plane of the flight.
     * bi-directional many-to-one association to Plane
     */
    @ManyToOne
    @JoinColumn(name = "id_plane")
    private Plane plane;

    /**
     * List of tickets.
     * bi-directional many-to-one association to Ticket
     */
    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;

    /**
     * Constructor.
     */
    public Flight() {
    }

    /**
     * Getter of the flight id.
     * @return the identifier.
     */
    public Integer getIdFlight() {
        return this.idFlight;
    }

    /**
     * Setter of the identifier of the flight.
     * @param idFlight is the identifier.
     */
    public void setIdFlight(final Integer idFlight) {
        this.idFlight = idFlight;
    }

    /**
     * Getter of the baggage number.
     * @return the baggage number.
     */
    public Integer getBaggageNumber() {
        return this.baggageNumber;
    }

    /**
     * Setter of the baggage number.
     * @param baggageNumber is the baggage number.
     */
    public void setBaggageNumber(final Integer baggageNumber) {
        this.baggageNumber = baggageNumber;
    }

    /**
     * Getter of the date of the start point.
     * @return the date of the start point.
     */
    public Timestamp getDateTimeFrom() {
        return this.dateTimeFrom;
    }

    /**
     * Setter of the date of the start point.
     * @param dateTimeFrom date of the start point.
     */
    public void setDateTimeFrom(final Timestamp dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    /**
     * Getter of the date of the final point.
     * @return the date of the final point.
     */
    public Timestamp getDateTimeTo() {
        return this.dateTimeTo;
    }

    /**
     * Setter of the date of the final point.
     * @param dateTimeTo is the date of the final point.
     */
    public void setDateTimeTo(final Timestamp dateTimeTo) {
        this.dateTimeTo = dateTimeTo;
    }

    /**
     * Getter of the delay of the flight.
     * @return the delay.
     */
    public Integer getDelay() {
        return this.delay;
    }

    /**
     * Setter of the delay of the flight.
     * @param delay is the delay of the flight.
     */
    public void setDelay(final Integer delay) {
        this.delay = delay;
    }

    /**
     * Getter of the gate number.
     * @return the gate number.
     */
    public Integer getGateNumber() {
        return this.gateNumber;
    }

    /**
     * Setter of the gate number.
     * @param gateNumber is the gate number.
     */
    public void setGateNumber(final Integer gateNumber) {
        this.gateNumber = gateNumber;
    }

    /**
     * Getter of the airport 1.
     * @return the airport 1.
     */
    public Airport getAirport1() {
        return this.airport1;
    }

    /**
     * Setter of the airport 1.
     * @param airport1 is the airport 1.
     */
    public void setAirport1(final Airport airport1) {
        this.airport1 = airport1;
    }

    /**
     * Getter of the airport 2.
     * @return the airport 2.
     */
    public Airport getAirport2() {
        return this.airport2;
    }

    /**
     * Setter of the airport 2.
     * @param airport2 is the airport 2.
     */
    public void setAirport2(final Airport airport2) {
        this.airport2 = airport2;
    }

    /**
     * Getter of the status of the flight.
     * @return the status of the flight.
     */
    public FlightStatus getFlightStatus() {
        return this.flightStatus;
    }

    /**
     * Setter of the status of the flight.
     * @param flightStatus is the status of the flight.
     */
    public void setFlightStatus(final FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    /**
     * Getter of the plane.
     * @return the plane.
     */
    public Plane getPlane() {
        return this.plane;
    }

    /**
     * Setter of the plane.
     * @param plane is the plane.
     */
    public void setPlane(final Plane plane) {
        this.plane = plane;
    }

    /**
     * Getter of the list of tickets.
     * @return the list of tickets.
     */
    public List<Ticket> getTickets() {
        return this.tickets;
    }

    /**
     * Setter of the list of tickets.
     * @param tickets is the list of tickets.
     */
    public void setTickets(final List<Ticket> tickets) {
        this.tickets = tickets;
    }

    /**
     * Function to add a ticket to the list.
     * @param ticket the ticket to add.
     * @return the added ticket.
     */
    public Ticket addTicket(final Ticket ticket) {
        getTickets().add(ticket);
        ticket.setFlight(this);

        return ticket;
    }

    /**
     * Function to remove a ticket from the list.
     * @param ticket the ticket to remove.
     * @return the removed ticked.
     */
    public Ticket removeTicket(final Ticket ticket) {
        getTickets().remove(ticket);
        ticket.setFlight(null);

        return ticket;
    }

}
