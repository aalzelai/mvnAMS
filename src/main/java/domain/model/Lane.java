package domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lane database table.
 * 
 */
@Entity
@NamedQuery(name="Lane.findAll", query="SELECT l FROM Lane l")
public class Lane implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_lane")
	private Integer idLane;

	@Column(name="lane_order")
	private Integer laneOrder;

	private String taken;

	//bi-directional many-to-one association to Airport
	@ManyToOne
	@JoinColumn(name="id_airport")
	private Airport airport;

	//bi-directional many-to-one association to LaneType
	@ManyToOne
	@JoinColumn(name="id_lane_type")
	private LaneType laneType;

	public Lane() {
	}

	public Integer getIdLane() {
		return this.idLane;
	}

	public void setIdLane(Integer idLane) {
		this.idLane = idLane;
	}

	public Integer getLaneOrder() {
		return this.laneOrder;
	}

	public void setLaneOrder(Integer laneOrder) {
		this.laneOrder = laneOrder;
	}

	public String getTaken() {
		return this.taken;
	}

	public void setTaken(String taken) {
		this.taken = taken;
	}

	public Airport getAirport() {
		return this.airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public LaneType getLaneType() {
		return this.laneType;
	}

	public void setLaneType(LaneType laneType) {
		this.laneType = laneType;
	}

}