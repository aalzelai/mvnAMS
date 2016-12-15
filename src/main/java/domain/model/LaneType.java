package domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lane_type database table.
 */
@Entity
@Table(name = "lane_type")
@NamedQuery(name = "LaneType.findAll", query = "SELECT l FROM LaneType l")
public class LaneType implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The identifier of the type of the lane.
     */
    @Id
    @Column(name = "id_lane_type")
    private Integer idLaneType;

    /**
     * The description.
     */
    private String description;

    /**
     * //bi-directional many-to-one association to Lane.
     */
    @OneToMany(mappedBy = "laneType")
    private List<Lane> lanes;

    /**
     * Constructor.
     */
    public LaneType() {
    }

    /**
     * Getter of the identifier of the lane type.
     * @return the identifier.
     */
    public Integer getIdLaneType() {
        return this.idLaneType;
    }

    /**
     * Setter of the identifier of the lane type.
     * @param idLaneType is the identifier.
     */
    public void setIdLaneType(final Integer idLaneType) {
        this.idLaneType = idLaneType;
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
     * Getter of the list of the lanes.
     * @return the list of the lanes.
     */
    public List<Lane> getLanes() {
        return this.lanes;
    }

    /**
     * Setter of the list of the lanes.
     * @param lanes is the list of the lanes.
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
        lane.setLaneType(this);

        return lane;
    }

    /**
     * Function to remove a lane from the list.
     * @param lane the lane to remove.
     * @return the removed lane.
     */
    public Lane removeLane(final Lane lane) {
        getLanes().remove(lane);
        lane.setLaneType(null);

        return lane;
    }

}