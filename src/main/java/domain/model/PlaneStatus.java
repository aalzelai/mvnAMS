package domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plane_status database table.
 */
@Entity
@Table(name = "plane_status")
@NamedQuery(name = "PlaneStatus.findAll",
            query =  "SELECT p FROM PlaneStatus p")
public class PlaneStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The status identifier.
     */
    @Id
    @Column(name = "id_status")
    private Integer idStatus;

    /**
     * The description.
     */
    private String description;

    /**
     * bi-directional many-to-one association to Plane.
     */
    @OneToMany(mappedBy = "planeStatus")
    private List<Plane> planes;

    /**
     * Constructor.
     */
    public PlaneStatus() {
    }

    /**
     * Getter of the identifier of the status.
     * @return the identifier.
     */
    public Integer getIdStatus() {
        return this.idStatus;
    }

    /**
     * Setter of the identifier.
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
     * @param description is the descripition.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Getter of the list of planes.
     * @return the list of planes.
     */
    public List<Plane> getPlanes() {
        return this.planes;
    }

    /**
     * Setter of the list of the planes.
     * @param planes is the list of the planes.
     */
    public void setPlanes(final List<Plane> planes) {
        this.planes = planes;
    }

    /**
     * Function to add a plane to the list.
     * @param plane is the plane to add.
     * @return the added plane.
     */
    public Plane addPlane(final Plane plane) {
        getPlanes().add(plane);
        plane.setPlaneStatus(this);

        return plane;
    }

    /**
     * Function to remove a plane from the list.
     * @param plane the plane to remove.
     * @return the removed plane.
     */
    public Plane removePlane(final Plane plane) {
        getPlanes().remove(plane);
        plane.setPlaneStatus(null);

        return plane;
    }

}