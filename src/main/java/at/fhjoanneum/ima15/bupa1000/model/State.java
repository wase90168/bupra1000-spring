package at.fhjoanneum.ima15.bupa1000.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String text;

    private String description;

    private boolean null_allowed;

    //@OneToMany(mappedBy = "state",cascade = CascadeType.ALL)
    //private List<Value> values;



    public State() {
    }

    public State(String text, String description, boolean null_allowed) {
        this.text = text;
        this.description = description;
        this.null_allowed = null_allowed;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNull_allowed() {
        return null_allowed;
    }

    public void setNull_allowed(boolean null_allowed) {
        this.null_allowed = null_allowed;
    }


}
