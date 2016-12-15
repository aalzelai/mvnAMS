package domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lane database table.
 */
@Entity
@NamedQuery(name = "Lane.findAll", query = "SELECT l FROM Lane l")
public class Lane implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The identifier of the lane.
     */
    @Id
    @Column(name = "id_lane")
    private Integer idLane;

    /**
     * The column of the lane order.
     */
    @Column(name = "lane_order")
    private Integer laneOrder;

    /**
     * To see if the lane is taken.
     */
    private String taken;

    /**
     * bi-directional many-to-one association to Airport.
     */
    @ManyToOne
    @JoinColumn(name = "id_airport")
    private Airport airport;

    /**
     * bi-directional many-to-one association to LaneType.
     */
    @ManyToOne
    @JoinColumn(name = "id_lane_type")
    private LaneType laneType;

    /**
     * Constructor.
     */
    public Lane() {
    }

    /**
     * Getter of the identifier of the lane.
     * @return the identifier.
     */
    public Integer getIdLane() {
        return this.idLane;
    }

    /**
     * Setter of the identifier of the lane.
     * @param idLane is the identifier.
     */
    public void setIdLane(final Integer idLane) {
        this.idLane = idLane;
    }

    /**
     * Getter of the lane order.
     * @return the order lane.
     */
    public Integer getLaneOrder() {
        return this.laneOrder;
    }

    /**
     * Setter of the lane order.
     * @param laneOrder is the order.
     */
    public void setLaneOrder(final Integer laneOrder) {
        this.laneOrder = laneOrder;
    }

    /**
     * Getter of the taken attribute.
     * @return attribute.
     */
    public String getTaken() {
        return this.taken;
    }

    /**
     * Setter of the taken attribute.
     * @param taken is the attribute.
     */
    public void setTaken(final String taken) {
        this.taken = taken;
    }

    /**
     * Getter of the airport.
     * @return the airport.
     */
    public Airport getAirport() {
        return this.airport;
    }

    /**
     * Setter of the airport.
     * @param airport is the airport.
     */
    public void setAirport(final Airport airport) {
        this.airport = airport;
    }

    /**
     * Getter of the lane type.
     * @return the lane type.
     */
    public LaneType getLaneType() {
        return this.laneType;
    }

    /**
     * Setter of the lane type.
     * @param laneType is the lane type.
     */
    public void setLaneType(final LaneType laneType) {
        this.laneType = laneType;
    }

}