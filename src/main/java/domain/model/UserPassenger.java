package domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_passenger database table.
 */
@Entity
@Table(name = "user_passenger")
@NamedQuery(name = "UserPassenger.findAll",
            query = "SELECT u FROM UserPassenger u")
public class UserPassenger implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The identifier.
     */
    @Id
    @Column(name = "id_user")
    private Integer idUser;

    /**
     * The email.
     */
    private String email;

    /**
     * The password.
     */
    private String password;

    /**
     * The telephone.
     */
    private String telephone;

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
     * bi-directional many-to-one association to Ticket.
     */
    @OneToMany(mappedBy = "userPassenger")
    private List<Ticket> tickets;

    /**
     * Constructor.
     */
    public UserPassenger() {
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
     * Getter of the email.
     * @return the email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter of the email.
     * @param email is the email.
     */
    public void setEmail(final String email) {
        this.email = email;
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
     * Getter of the telephone.
     * @return the telephone.
     */
    public String getTelephone() {
        return this.telephone;
    }

    /**
     * Setter of the telephone.
     * @param telephone is the telephone.
     */
    public void setTelephone(final String telephone) {
        this.telephone = telephone;
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
     * Getter of the list of the tickets.
     * @return the list of the tickets.
     */
    public List<Ticket> getTickets() {
        return this.tickets;
    }

    /**
     * Setter of the list of the tickets.
     * @param tickets is the list of the tickets.
     */
    public void setTickets(final List<Ticket> tickets) {
        this.tickets = tickets;
    }

    /**
     * Function to add a ticket to the list.
     * @param ticket is the ticket to add.
     * @return the added ticket.
     */
    public Ticket addTicket(final Ticket ticket) {
        getTickets().add(ticket);
        ticket.setUserPassenger(this);

        return ticket;
    }

    /**
     * Function to remove a ticket from the list.
     * @param ticket is the ticket to remove.
     * @return the removed ticket.
     */
    public Ticket removeTicket(final Ticket ticket) {
        getTickets().remove(ticket);
        ticket.setUserPassenger(null);

        return ticket;
    }

}
