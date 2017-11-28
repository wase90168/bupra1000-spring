package at.fh.ima.swengs.flightexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;


import javax.persistence.*;


@Entity
public class Values {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private BigDecimal value;

    @Version
    private long version;


}