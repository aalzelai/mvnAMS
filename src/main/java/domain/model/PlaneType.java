package domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plane_type database table.
 */
@Entity
@Table(name = "plane_type")
@NamedQuery(name = "PlaneType.findAll", query = "SELECT p FROM PlaneType p")
public class PlaneType implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The plane type identifier.
     */
    @Id
    @Column(name = "id_plane_type")
    private Integer idPlaneType;

    /**
     * The description.
     */
    private String description;

    /**
     * bi-directional many-to-one association to Plane.
     */
    @OneToMany(mappedBy = "planeType")
    private List<Plane> planes;

    /**
     * Constructor.
     */
    public PlaneType() {
    }

    /**
     * Getter of the identifier of the type of the plane.
     * @return the identifier.
     */
    public Integer getIdPlaneType() {
        return this.idPlaneType;
    }

    /**
     * Setter of the identifier of the type of the plane.
     * @param idPlaneType is the identifier.
     */
    public void setIdPlaneType(final Integer idPlaneType) {
        this.idPlaneType = idPlaneType;
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
     * Getter of the list of the planes.
     * @return the list of planes.
     */
    public List<Plane> getPlanes() {
        return this.planes;
    }

    /**
     * Setter of the list of the planes.
     * @param planes is the list of planes.
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
        plane.setPlaneType(this);

        return plane;
    }

    /**
     * Function to remove a plane from the list.
     * @param plane is the plane to remove.
     * @return the removed plane.
     */
    public Plane removePlane(final Plane plane) {
        getPlanes().remove(plane);
        plane.setPlaneType(null);

        return plane;
    }

}