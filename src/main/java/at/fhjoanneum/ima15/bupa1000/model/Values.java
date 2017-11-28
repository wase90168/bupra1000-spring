package at.fhjoanneum.ima15.bupa1000.model;

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