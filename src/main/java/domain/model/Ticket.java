package domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tickets database table.
 */
@Entity
@Table(name = "tickets")
@NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The ticket identifier.
     */
    @Id
    @Column(name = "id_ticket")
    private Integer idTicket;

    /**
     * bi-directional many-to-one association to Flight.
     */
    @ManyToOne
    @JoinColumn(name = "id_flight")
    private Flight flight;

    /**
     * bi-directional many-to-one association to UserPassenger.
     */
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserPassenger userPassenger;

    /**
     * Constructor.
     */
    public Ticket() {
    }

    /**
     * Getter of the identifier of the ticket.
     * @return the identifier.
     */
    public Integer getIdTicket() {
        return this.idTicket;
    }

    /**
     * Setter of the identifier of the ticket.
     * @param idTicket is the identifier of the ticket.
     */
    public void setIdTicket(final Integer idTicket) {
        this.idTicket = idTicket;
    }

    /**
     * Getter of the flight.
     * @return the flight.
     */
    public Flight getFlight() {
        return this.flight;
    }

    /**
     * Setter of the flight.
     * @param flight is the flight.
     */
    public void setFlight(final Flight flight) {
        this.flight = flight;
    }

    /**
     * Getter of the passenger.
     * @return the passenger.
     */
    public UserPassenger getUserPassenger() {
        return this.userPassenger;
    }

    /**
     * Setter of the passenger.
     * @param userPassenger is the passenger.
     */
    public void setUserPassenger(final UserPassenger userPassenger) {
        this.userPassenger = userPassenger;
    }

}