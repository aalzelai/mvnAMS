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
@NamedQuery(name="Flight.findAll", query="SELECT f FROM Flight f")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_flight")
	private Integer idFlight;

	@Column(name="baggage_number")
	private Integer baggageNumber;

	@Column(name="date_time_from")
	private Timestamp dateTimeFrom;

	@Column(name="date_time_to")
	private Timestamp dateTimeTo;

	private Integer delay;

	@Column(name="gate_number")
	private Integer gateNumber;

	//bi-directional many-to-one association to Airport
	@ManyToOne
	@JoinColumn(name="id_airport_from")
	private Airport airport1;

	//bi-directional many-to-one association to Airport
	@ManyToOne
	@JoinColumn(name="id_airport_to")
	private Airport airport2;

	//bi-directional many-to-one association to FlightStatus
	@ManyToOne
	@JoinColumn(name="id_status")
	private FlightStatus flightStatus;

	//bi-directional many-to-one association to Plane
	@ManyToOne
	@JoinColumn(name="id_plane")
	private Plane plane;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="flight")
	private List<Ticket> tickets;

	public Flight() {
	}

	public Integer getIdFlight() {
		return this.idFlight;
	}

	public void setIdFlight(Integer idFlight) {
		this.idFlight = idFlight;
	}

	public Integer getBaggageNumber() {
		return this.baggageNumber;
	}

	public void setBaggageNumber(Integer baggageNumber) {
		this.baggageNumber = baggageNumber;
	}

	public Timestamp getDateTimeFrom() {
		return this.dateTimeFrom;
	}

	public void setDateTimeFrom(Timestamp dateTimeFrom) {
		this.dateTimeFrom = dateTimeFrom;
	}

	public Timestamp getDateTimeTo() {
		return this.dateTimeTo;
	}

	public void setDateTimeTo(Timestamp dateTimeTo) {
		this.dateTimeTo = dateTimeTo;
	}

	public Integer getDelay() {
		return this.delay;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}

	public Integer getGateNumber() {
		return this.gateNumber;
	}

	public void setGateNumber(Integer gateNumber) {
		this.gateNumber = gateNumber;
	}

	public Airport getAirport1() {
		return this.airport1;
	}

	public void setAirport1(Airport airport1) {
		this.airport1 = airport1;
	}

	public Airport getAirport2() {
		return this.airport2;
	}

	public void setAirport2(Airport airport2) {
		this.airport2 = airport2;
	}

	public FlightStatus getFlightStatus() {
		return this.flightStatus;
	}

	public void setFlightStatus(FlightStatus flightStatus) {
		this.flightStatus = flightStatus;
	}

	public Plane getPlane() {
		return this.plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setFlight(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setFlight(null);

		return ticket;
	}

}
