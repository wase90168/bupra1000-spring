package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dimension {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String dimension;

    private String description;

    public Dimension() {
    }

    public Dimension(String dimension, String description) {

        this.dimension = dimension;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
