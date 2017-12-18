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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
    private List<Value> values;



    public State() {
    }

    public State(String text, String description, boolean null_allowed, List<Value> values, long version) {
        this.text = text;
        this.description = description;
        this.null_allowed = null_allowed;
        this.values = values;

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

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }


}
